package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.result.Result;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author gaoxishan
 * @date 2021/1/24 17:55
 */
@RestController
@RequestMapping("admin/product/")
@CrossOrigin
public class FileUploadController {
    @RequestMapping("fileUpload")
    public Result fileUpload(@RequestParam MultipartFile file) throws IOException, MyException {
        String url = "http://192.168.200.128:8080";
        String path = FileUploadController.class.getClassLoader().getResource("tracker.conf").getPath();
        ClientGlobal.init(path);
        // 获得tracker连接
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer connection = trackerClient.getConnection();
        // 通过tracker获得storage
        StorageClient storageClient = new StorageClient(connection, null);
        //上传文件
        String originalFilename = file.getOriginalFilename();
        String[] jpgs = storageClient.upload_file(file.getBytes(), StringUtils.getFilenameExtension(originalFilename), null);
        // 返回url
        for (String jpg : jpgs) {
            url = url + "/" + jpg;
        }
        return Result.ok(url);
    }
}
