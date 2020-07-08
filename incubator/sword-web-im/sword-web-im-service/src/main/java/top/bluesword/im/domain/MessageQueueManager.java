package top.bluesword.im.domain;

import reactor.core.publisher.FluxSink;
import top.bluesword.im.util.InetSocketAddressAssistant;

import java.net.InetSocketAddress;
import java.util.*;

/**
 * @author 李林峰
 */
public class MessageQueueManager {

    private static final Map<String,FluxSink<String>> MESSAGE_QUEUES = new HashMap<>();
    private static final Map<String,String> NAMES = new HashMap<>();
    private static final Map<String,String> IP_NAMES = new HashMap<>();
    private static final Map<String, List<String>> ADDRESS_MAP = new HashMap<>();

    public static void putMessageQueue(InetSocketAddress address, FluxSink<String> fluxSink) {
        String addressStr = address.toString();
        MESSAGE_QUEUES.put(addressStr,fluxSink);
        String ip = InetSocketAddressAssistant.getHostAddress(address);
        if (ADDRESS_MAP.containsKey(ip)) {
            ADDRESS_MAP.get(ip).add(addressStr);
        } else {
            ADDRESS_MAP.put(ip,new ArrayList<>(List.of(addressStr)));
        }
        if (IP_NAMES.containsKey(ip)){
            NAMES.put(addressStr,IP_NAMES.get(ip));
        }
    }

    public static FluxSink<String> getMessageQueue(InetSocketAddress address) {
        return MESSAGE_QUEUES.get(address.toString());
    }

    public static Collection<MessageQueueInfo> getMessageQueueInfos() {
        Map<String,MessageQueueInfo> infoMap = new HashMap<>(MESSAGE_QUEUES.size());
        Set<String> addresses = MESSAGE_QUEUES.keySet();
        for (String address : addresses) {
            infoMap.put(address,new MessageQueueInfo(address,address));
        }
        for (Map.Entry<String, String> nameEntry : NAMES.entrySet()) {
            if (infoMap.containsKey(nameEntry.getKey())) {
                infoMap.get(nameEntry.getKey()).setName(nameEntry.getValue());
            }
        }
        return infoMap.values();
    }

    public static FluxSink<String> getMessageQueue(String addressStr) {
        return MESSAGE_QUEUES.get(addressStr);
    }

    public static boolean contains(String address) {
        return MESSAGE_QUEUES.containsKey(address);
    }

    public static void remove(InetSocketAddress address) {
        String addressStr = address.toString();
        MESSAGE_QUEUES.remove(addressStr);
        NAMES.remove(addressStr);
        String ip = InetSocketAddressAssistant.getHostAddress(address);
        ADDRESS_MAP.get(ip).remove(addressStr);
    }

    public static void setName(String ip, String name) {
        IP_NAMES.put(ip,name);
        List<String> addresses = ADDRESS_MAP.get(ip);
        for (String address : addresses) {
            NAMES.put(address,name);
        }
    }
}
