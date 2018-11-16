package com.sr.searchroom.service;

import com.qiniu.http.Response;

import java.io.File;
import java.io.InputStream;

/**
 * Created by 温小萌 on 2018/11/15
 */
public interface IQiniuService {
    /**
     * 上传文件
     * @param file
     * @return
     * @throws Exception
     */
    Response uploadFile(File file) throws Exception;

    /**
     * 流文件上传
     * @param inputStream
     * @return
     * @throws Exception
     */
    Response uploadFile(InputStream inputStream) throws Exception;

    /**
     * 根据key删除文件
     * @param key
     * @return
     * @throws Exception
     */
    Response delete(String key) throws Exception;
}
