package top.bluesword.im.domain;

import lombok.Data;

/**
 * @author 李林峰
 */
@Data
public class MessageQueueInfo {

    private String name;

    private String address;

    public MessageQueueInfo(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
