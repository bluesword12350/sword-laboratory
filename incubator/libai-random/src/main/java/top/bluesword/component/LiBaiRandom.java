package top.bluesword.component;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import com.alibaba.fastjson.JSON;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.mapdb.Serializer;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import static top.bluesword.commands.LiBaiRandomCommandMessage.*;

/**
 * @author 李林峰
 */
@Component
public class LiBaiRandom {

    private static final DB DB = DBMaker.fileDB("LiBai.db").fileMmapEnable().checksumHeaderBypass().make();
    private static final HTreeMap.KeySet<String> STOREHOUSE = DB.hashSet("storehouse", Serializer.STRING).createOrOpen();
    private static final HTreeMap.KeySet<String> ENJOY = DB.hashSet("enjoy", Serializer.STRING).createOrOpen();
    private static final HTreeMap.KeySet<String> SHELVE = DB.hashSet("shelve", Serializer.STRING).createOrOpen();
    private static final Random RANDOM = new Random();

    static {
        storehouseInit();
    }

    private static void storehouseInit(){
        if (STOREHOUSE.isEmpty()) {
            var liBaiJson = new String(IoUtil.readBytes(new ClassPathResource("LiBai.json").getStream()),StandardCharsets.UTF_8);
            STOREHOUSE.addAll(
                    JSON.parseObject(liBaiJson).getJSONArray("诗集").toJavaList(String.class)
            );
        }
    }

    public static String randomGet(){
        storehouseInit();
        int size = STOREHOUSE.size();
        if (size < 1) {
            return "仓库为空";
        }
        for (String sj : STOREHOUSE) {
            if (RANDOM.nextInt(size--)==0) {
                return sj;
            }
        }
        return PROGRAM_EXCEPTION;
    }

    public static String randomGetEnjoy(){
        int size = ENJOY.size();
        if (size < 1) {
            return "收藏为空";
        }
        for (String sj : ENJOY) {
            if (RANDOM.nextInt(size--)==0) {
                return sj;
            }
        }
        return PROGRAM_EXCEPTION;
    }

    public static String resetEnjoy(){
        ENJOY.removeIf(STOREHOUSE::add);
        return COMPLETE;
    }

    public static boolean shelve(String sj){
        if (STOREHOUSE.remove(sj)) {
            if (SHELVE.add(sj)) {
                return true;
            }
            STOREHOUSE.add(sj);
        }
        return false;
    }

    public static boolean enjoy(String sj) {
        if (STOREHOUSE.remove(sj)) {
            if (ENJOY.add(sj)) {
                return true;
            }
            STOREHOUSE.add(sj);
        }
        return false;
    }

    public static LiBaiStatistic statistic() {
        return LiBaiStatistic.builder()
                .enjoy(ENJOY.getSize())
                .storehouse(STOREHOUSE.getSize())
                .shelve(SHELVE.getSize())
                .build();
    }

    @PreDestroy
    public static void destroy() {
        DB.close();
    }

}
