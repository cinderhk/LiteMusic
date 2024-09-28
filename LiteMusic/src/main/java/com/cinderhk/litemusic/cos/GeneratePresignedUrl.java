package com.cinderhk.litemusic.cos;

import java.net.URL;
import java.util.Date;


import com.cinderhk.litemusic.entity.CosConfig;
import com.cinderhk.litemusic.service.ICosConfigService;
import com.cinderhk.litemusic.utils.R;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.model.GeneratePresignedUrlRequest;
import com.qcloud.cos.model.ResponseHeaderOverrides;
import com.qcloud.cos.region.Region;
import com.qcloud.cos.utils.DateUtils;

/**
 * GeneratePresignedUrlDemo展示了生成预签名的下载链接与上传连接的使用示例.
 * 用于可将生成的连接分发给移动端或者他人, 即可实现在签名有效期内上传或者下载文件.
 */
public class GeneratePresignedUrl {



    private static COSClient createCli(String secretId,String secretKey,String region) {
        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置bucket的区域, COS地域的简称请参照 https://www.qcloud.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region(region));
        // 3 生成cos客户端
        COSClient cosclient = new COSClient(cred, clientConfig);

        return cosclient;
    }

    /**
     * 获取预签名的下载链接, 并设置返回的content-type, cache-control等http头
     *
     * @param key 存储桶中的文件键名
     * @return 包含预签名下载URL的结果对象
     */


    public R generatePresignedDownloadUrl(CosConfig cosConfig,String key) {
        // 1 初始化用户身份信息(secretId, secretKey)

        String secretId =cosConfig.getSecretId();
        String secretKey =cosConfig.getSecretKey();
        String bucketName =cosConfig.getBucketName();
        String region = cosConfig.getRegion();
        COSClient cosClient =createCli(secretId,secretKey,region);
        if (cosClient == null) {
            return R.error().message("COSClient is not initialized.");
        }

        GeneratePresignedUrlRequest req =
                new GeneratePresignedUrlRequest(bucketName, key, HttpMethodName.GET);
        ResponseHeaderOverrides responseHeaders = new ResponseHeaderOverrides();
        responseHeaders.setContentLanguage("zh-CN");
        responseHeaders.setCacheControl("no-cache");
        responseHeaders.setExpires(DateUtils.formatRFC822Date(new Date(System.currentTimeMillis() + 24 * 3600 * 1000)));

        req.setResponseHeaders(responseHeaders);
        req.setExpiration(new Date(System.currentTimeMillis() + 30 * 60 * 1000));

        URL url = null;
        try {
            url = cosClient.generatePresignedUrl(req);
            return R.ok().data("url", url.toString());
        } catch (Exception e) {
            e.printStackTrace();

        }
        return R.error();
    }


    // 清理资源
    public void shutdown(COSClient cosClient) {
        if (cosClient != null) {
            cosClient.shutdown();
        }
    }
}