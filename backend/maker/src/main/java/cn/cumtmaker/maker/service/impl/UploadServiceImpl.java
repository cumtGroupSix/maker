package cn.cumtmaker.maker.service.impl;

import cn.cumtmaker.maker.service.UploadService;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.COSObject;
import com.qcloud.cos.model.GetObjectRequest;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {

    /**
     * 腾讯云上传文件接口
     * @param multipartFile
     * @return
     */
    @Override
    public String upload(MultipartFile multipartFile) {
        COSCredentials cred = new BasicCOSCredentials("AKID3NTWkcfzDQTmvoddXFvP1vZ4lHmhunX4", "Sjx67zXo38ZHwOY0LjxvlWfwAAxnSBl8");
        ClientConfig clientConfig = new ClientConfig(new Region("ap-beijing"));
        COSClient cosClient = new COSClient(cred, clientConfig);
        String bucketName = "blog-1258589922";
        // 获取文件名
        String fileName = multipartFile.getOriginalFilename();
        // 获取文件后缀
        String prefix=fileName.substring(fileName.lastIndexOf("."));
        // 用uuid作为文件名，防止生成的临时文件重复
        File file = null;
        try {
            file = File.createTempFile(UUID.randomUUID().toString(), prefix);
            // MultipartFile to File
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String key =UUID.randomUUID().toString()+ prefix;
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file);
        cosClient.putObject(putObjectRequest);
        cosClient.shutdown();
        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, key);
        COSObject object = cosClient.getObject(getObjectRequest);
        String uri = object.getObjectContent().getHttpRequest().getURI().toString();
        return uri;
    }
}
