package com.yizhen.demo.designPattern.createType.factory.plainFactory;

/**
 * 消息类型
 * @author  milo
 */
public enum MessageType {

    SMS("sms","short messageService3"),

    MS("ms","mail service"),

    TS("ts","transport service");
    /**
     * 键
     */
    private String key;
    /**
     * 值
     */
    private String value;

    /**
     * 有参构造器
     * @param key
     * @param value
     */
    MessageType(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }
}
