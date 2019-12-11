package com.yangxi.szy.service;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import com.yangxi.szy.comm.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class OssService {
    private static final Logger log = LoggerFactory.getLogger(OssService.class);

    @Value("${alioss.endpoint}")
    private String endpoint;

    @Value("${alioss.accessKeyId}")
    private String accessKeyId;

    @Value("${alioss.accessKeySecret}")
    private String accessKeySecret;

    @Value("${alioss.bucket}")
    private String bucket;

    //上传文件对象
    public String upFileObject(File file) {
        try {
            // 创建OSSClient实例
            OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);

            //实际进行文件上传
            String hash = MD5Util.getFileMD5(file);

            //检查文件是否存在，避免重复上传
            if (!client.doesObjectExist(bucket, hash)) {
                //实际上传到OSS空间
                PutObjectResult por = client.putObject(bucket, hash, file);
            }

            //删除上传的临时文件并关闭客户端
            file.delete();
            client.shutdown();

            //返回文件哈希
            return hash;
        } catch (Exception e) {
            return "";
        }
    }
}
