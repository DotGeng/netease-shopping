package com.netease.service.impl;

import com.netease.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by YukunGeng on 2018/3/27.
 */
@Service
public class FileServiceImpl implements FileService {

    @Value("${server.port}")
    private String port;
    @Override
    public String uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        // 把图片的可访问的url写入数据库
        String pictureURL= "http://localhost:" + port + "/myimage/" + fileName;
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
        return pictureURL;
    }
}
