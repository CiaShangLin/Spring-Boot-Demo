package org.example.controller;

import org.example.pojo.Result;
import org.example.utils.ImgurUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileUploadController {

    @Autowired
    private ImgurUploader imgurUploader ;

    @PostMapping("upload")
    public Result<String> upload(MultipartFile file) throws IOException {
        try {
            String url = imgurUploader.uploadImage(file);
            return Result.success(url);
        } catch (IOException e) {
            return Result.error("上傳失敗：" + e.getMessage());
        }
//        String originalFilename = file.getOriginalFilename();
//        String fileName = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf('.'));
//        file.transferTo(
//                new File("C:\\Users\\User\\IdeaProjects\\Spring-Boot-Demo\\Files\\"+fileName)
//        );
//        return Result.success("url訪問地址");
    }
}
