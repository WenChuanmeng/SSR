package com.sr.searchroom.config;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import java.io.ByteArrayInputStream;

/**
 * Created by 温小萌 on 2018/11/15
 */
public class QiniuUploadConfig {
    public static String upload(byte[] uploadBytes, String fileName){

        Configuration configuration = new Configuration(Zone.zone0());
        //其他配置参数
        UploadManager uploadManager = new UploadManager(configuration);
        //生成上传凭证
        String accessKey = "AUfPWd0cAEeSJ3hSq0R-Byvt0DDnMBOl_sT1Vs0u";
        String secretKey = "ailG1lICCFwlWABhVk-3DtquR2ai8az2vMHEwSDQ";
        String bucket = "room";

        String key = System.currentTimeMillis() + fileName;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(uploadBytes);
        Auth auth = Auth.create(accessKey, secretKey);
        String uploadToken = auth.uploadToken(bucket);

        try {
            Response response = uploadManager.put(byteArrayInputStream, key, uploadToken, null, null);

            //解析上传成功的结果
            DefaultPutRet defaultPutRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(defaultPutRet.hash);
            System.out.println(defaultPutRet.key);

        } catch (QiniuException e) {
            e.printStackTrace();
        }
        return null;
    }
}