package com.netease.BaseController;


/**
 * Created by YukunGeng on 2018/3/12.
 */
public class ResponseStatus {
    private String sessionId;
    private int code;
    private String msg;
    private String content;

    public ResponseStatus(int code, String msg, String content) {
        this.code = code;
        this.msg = msg;
        this.content = content;
    }
    public ResponseStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.content = "";
    }

    public ResponseStatus(String sessionId, int code, String msg, String content) {
        this.sessionId = sessionId;
        this.code = code;
        this.msg = msg;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
