package com.yangxi.szy;

import com.yangxi.szy.comm.DateHelper;
import com.yangxi.szy.comm.FileHelper;
import com.yangxi.szy.service.OssService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@RestController
@RequestMapping("/upload")
public class UploadHandler {
    private static final Logger log = LoggerFactory.getLogger(UploadHandler.class);

    @Autowired
    private OssService ossService;

    @PostMapping(value = "/oss")
    @CrossOrigin(methods = {RequestMethod.POST}, origins = "*")
    public String oss(
            @RequestParam("file") MultipartFile upFile,
            HttpServletRequest request) {
        //上传到OSS
        return  saveUpFile(upFile, request, "OSS");
    }

    private String saveUpFile(MultipartFile upFile,
                              HttpServletRequest request,
                              String type){
        //检查上传路径是否存在，不存在则新建立
        String path = request.getRealPath("/upload") + "/";
        FileHelper.chkDir(path);

        //得到上传目标文件
        String targetPath = path + DateHelper.curTimeStr() + ".jpg";
        File saveFile = new File(targetPath);
        if (saveFile.exists()) {
            saveFile.delete();
        }

        //转存到上传目录
        try {
            //接受文件到缓存
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
            out.write(upFile.getBytes());
            out.flush();
            out.close();

            //根据处理类型分别上传到oss或者进行身份证参数解析
            String retStr = "";
            if (type.equalsIgnoreCase("OSS")){
                retStr = ossService.upFileObject(saveFile);
            }

            //返回处理结构
            return retStr;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
