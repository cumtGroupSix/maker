package cn.cumtmaker.maker.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    String upload(MultipartFile multipartFile);

}
