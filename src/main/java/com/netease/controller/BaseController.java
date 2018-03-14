package com.netease.controller;

import com.netease.BaseController.ResponseStatus;
import com.netease.BaseParam.BaseCode;

/**
 * Created by YukunGeng on 2018/3/12.
 */
public class BaseController {
    public ResponseStatus success(String sessionid,String msg, String content) {
        return new ResponseStatus(sessionid,BaseCode.SUCCES_CODE, msg, content);
    }


    public ResponseStatus success(String msg) {
        return new ResponseStatus(BaseCode.SUCCES_CODE, msg);
    }
    public ResponseStatus error(String msg, String content) {
        return new ResponseStatus(BaseCode.ERROR_CODE, msg, content);
    }
}
