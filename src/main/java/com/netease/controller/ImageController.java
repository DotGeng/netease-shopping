package com.netease.controller;

import com.netease.BaseController.ResponseStatus;
import com.netease.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by YukunGeng on 2018/3/27.
 */
@RestController
public class ImageController extends BaseController {

    @Value("${spring.web.upload-path}")
    private String location;

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/image/upload", method = RequestMethod.POST)
    public ResponseStatus upload(@RequestParam(value = "file") MultipartFile file) {
        System.out.println("调用upload");
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String fileTail = fileName.substring(fileName.lastIndexOf(".") + 1);
        String filePath = location + "myimage/";
        String url = "";
        try {
            url = fileService.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // 处理异常，可以打印出日志，供排错，为了简单起见，这里不做处理。
        }
        return success("ok", "", url);
    }

}
