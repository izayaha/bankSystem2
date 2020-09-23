package com.iza.common;

/**
 * projectName:  bankSystem
 *
 * @author: xuwei
 * ime:  2020/9/3 20:25
 * description:
 */
public class JsonResult {
    private  int code;
    private Object info;

    public JsonResult() {
    }

    public JsonResult(int code, Object info) {
        this.code = code;
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }
}
