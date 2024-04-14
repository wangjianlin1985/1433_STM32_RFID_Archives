package com.bs.glr.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;


@RestController
@RequestMapping("/user")
public class FileController {


    @RequestMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        // Endpoint以杭州为例，其它Region请按实际情况填写。

        OSS ossClient = null;

        try {
            ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            String filename = file.getOriginalFilename();
            String newName = UUID.randomUUID().toString() + filename;

            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest("scwtest20200706", "img/"+newName, file.getInputStream());

            // 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
            // ObjectMetadata metadata = new ObjectMetadata();
            // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
            // metadata.setObjectAcl(CannedAccessControlList.Private);
            // putObjectRequest.setMetadata(metadata);

            // 上传文件。
            ossClient.putObject(putObjectRequest);


            return "https://scwtest20200706.oss-cn-beijing.aliyuncs.com/img/"+newName;
        }catch (Exception e) {
            e.printStackTrace();
            return "";
        } finally {
            if(ossClient != null){

                ossClient.shutdown();
            }
        }


    }
}
