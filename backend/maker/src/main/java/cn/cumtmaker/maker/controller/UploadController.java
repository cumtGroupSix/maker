package cn.cumtmaker.maker.controller;

import cn.cumtmaker.maker.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UploadController {

    @Autowired
    UploadService uploadService;

    /**
     * 腾讯云上传图片接口
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public String uploadImage(@RequestParam MultipartFile file){
        String uri = uploadService.upload(file);
        return uri;
    }

}
