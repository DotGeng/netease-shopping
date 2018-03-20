package com.netease.controller;

import com.netease.BaseController.ResponseStatus;
import com.netease.BaseController.SalerResponseStatus;
import com.netease.BaseParam.BaseCode;

/**
 * Created by YukunGeng on 2018/3/12.
 */
public class BaseController {
    public ResponseStatus success(String sessionid, String msg, String userName, Object content) {
        return new ResponseStatus(sessionid, BaseCode.SUCCES_CODE, msg, userName, content);
    }


    public ResponseStatus success(String msg, String userName) {
        return new ResponseStatus(BaseCode.SUCCES_CODE, msg, userName);
    }

    public ResponseStatus success(String msg, String userName, Object content) {
        return new ResponseStatus(BaseCode.SUCCES_CODE, msg, userName, content);
    }

    public ResponseStatus error(String msg, String userName, Object content) {
        return new ResponseStatus(BaseCode.ERROR_CODE, msg, userName, content);
    }

    public SalerResponseStatus success4Saler(String msg, String salerName, Object content){
        return new SalerResponseStatus(BaseCode.SUCCES_CODE, msg, salerName, content);
    }
}
