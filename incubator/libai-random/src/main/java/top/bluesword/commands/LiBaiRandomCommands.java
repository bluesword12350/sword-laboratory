package top.bluesword.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import top.bluesword.component.LiBaiRandom;
import top.bluesword.component.LiBaiStatistic;

/**
 * @author 李林峰
 */
@ShellComponent
public class LiBaiRandomCommands {

    private String cache;

    @ShellMethod(value = "从仓库中随机获取诗句",key = "get")
    public String get() {
        return cache = LiBaiRandom.randomGet();
    }

    @ShellMethod(value = "从收藏中随机获取诗句",key = "get-enjoy")
    public String getEnjoy() {
        return LiBaiRandom.randomGetEnjoy();
    }

    @ShellMethod(value = "查询当前缓存",key = "cache")
    public String cache() {
        if (cache == null) {
            return LiBaiRandomCommandMessage.NO_CACHE;
        }
        return cache;
    }

    @ShellMethod(value = "搁置诗句",key = "shelve")
    public String shelve() {
        if (cache == null) {
            return LiBaiRandomCommandMessage.NO_CACHE;
        }
        boolean isShelve = LiBaiRandom.shelve(cache);
        if (isShelve) {
            cache = null;
        }
        return Boolean.toString(isShelve);
    }

    @ShellMethod(value = "收藏诗句",key = "enjoy")
    public String enjoy() {
        if (cache == null) {
            return LiBaiRandomCommandMessage.NO_CACHE;
        }
        boolean isEnjoy = LiBaiRandom.enjoy(cache);
        if (isEnjoy) {
            cache = null;
        }
        return Boolean.toString(isEnjoy);
    }

    @ShellMethod(value = "重置收藏",key = "reset-enjoy")
    public String resetEnjoy() {
        return LiBaiRandom.resetEnjoy();
    }

    @ShellMethod(value = "统计数据",key = "statistic")
    public LiBaiStatistic statistic() {
        return LiBaiRandom.statistic();
    }
}