package com.netease.recventry;

/**
 * Created by YukunGeng on 2018/3/18.
 */
public class SalerInfo {
    private String salerName;
    private String password;

    public SalerInfo(String salerName, String password) {
        this.salerName = salerName;
        this.password = password;
    }

    public String getSalerName() {
        return salerName;
    }

    public void setSalerName(String salerName) {
        this.salerName = salerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
