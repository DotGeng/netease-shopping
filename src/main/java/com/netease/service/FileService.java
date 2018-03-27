package com.netease.service;

/**
 * Created by YukunGeng on 2018/3/27.
 */
public interface FileService {
    // 上传图片，并最终返回图片的访问路径
    public String uploadFile(byte[] file, String filePath, String fileName) throws Exception;
}
