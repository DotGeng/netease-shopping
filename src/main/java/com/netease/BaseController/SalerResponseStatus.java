package com.netease.BaseController;

/**
 * Created by YukunGeng on 2018/3/19.
 */
public class SalerResponseStatus {

    private String sessionId;
    private int code;
    private String msg;
    private String salerName;
    private Object content;

    public SalerResponseStatus(int code, String msg, String salerName, Object content) {
        this.code = code;
        this.msg = msg;
        this.salerName = salerName;
        this.content = content;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSalerName() {
        return salerName;
    }

    public void setSalerName(String salerName) {
        this.salerName = salerName;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
