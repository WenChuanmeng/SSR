package com.sr.searchroom.service.user;

import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.sr.searchroom.service.IQiniuService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;

/**
 * Created by 温小萌 on 2018/11/15
 */
@Service
public class QiniuServiceImpl implements IQiniuService,InitializingBean {

    @Autowired
    private UploadManager uploadManager;
    @Autowired
    private BucketManager bucketManager;
    @Autowired
    private Auth auth;

    @Value("${qiniu.bucket}")
    private String bucket;

    private StringMap putPolicy;

    @Override
    public Response uploadFile(File file) throws Exception {

        Response response = uploadManager.put(file, null, getUploadToken());
        int flag = 0;
        while (response.needRetry() && flag < 3) {
            response = uploadManager.put(file, null, getUploadToken());
            flag++;
        }
        return response;
    }

    @Override
    public Response uploadFile(InputStream inputStream) throws Exception {
        Response response = uploadManager.put(inputStream, null, getUploadToken(), null, null);
        int flag = 0;
        while (response.needRetry() && flag < 3) {
            response = uploadManager.put(inputStream, null, getUploadToken(), null, null);
            flag++;
        }
        return response;
    }

    @Override
    public Response delete(String key) throws Exception {
        Response response = bucketManager.delete(bucket, key);

        return response;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        this.putPolicy = new StringMap();
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"width\":$(imageInfo.width),\"height\":$(imageInfo.height)}");
    }

    /**
     * 获取上传凭证
     * @return
     */
    private String getUploadToken() {
        return auth.uploadToken(bucket);
    }
}
