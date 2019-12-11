package com.yangxi.szy.comm;

import org.apache.http.util.TextUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.apache.commons.codec.binary.Base64.encodeBase64;

public class FileHelper {
    //对文件进行base64编码
    public static String base64(String filePath){
        //检查文件有效性
        File file = new File(filePath);
        if (TextUtils.isEmpty(filePath) || !file.exists())
            return "";

        try {
            byte[] content = new byte[(int) file.length()];
            FileInputStream finputstream = new FileInputStream(file);
            finputstream.read(content);
            finputstream.close();

            //返回处理结果
            return new String(encodeBase64(content));
        } catch (IOException e) {
            return "";
        }
    }

    //检查指定路径是否存在，不存在则新建立
    public static void chkDir(String path){
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
    }
}
