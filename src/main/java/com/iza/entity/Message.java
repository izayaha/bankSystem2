package com.iza.entity;

/**
 * projectName:  bankSystem
 *
 * @author: xuwei
 * ime:  2020/9/5 15:05
 * description:
 */
public class Message {
    private int code;
    private String info;
    private Object object;

    public Message() {
    }

    public Message(int code, String info, Object object) {
        this.code = code;
        this.info = info;
        this.object = object;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Message{" +
                "code=" + code +
                ", info='" + info + '\'' +
                ", object=" + object +
                '}';
    }
}
