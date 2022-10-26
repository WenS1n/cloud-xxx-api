package cn.vesns.common;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import okio.BufferedSink;
import okio.Okio;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * OkHttp3 工具类
 *
 * @author arctique
 * @date 2020/9/17 15:44
 */
@Slf4j
public class OkHttpUtil {

    /**
     * Get请求
     *
     * @param url URL地址
     * @return 返回结果
     */
    public static String get(String url) {
        String result = null;
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            Request request = new Request.Builder().url(url).build();
            Response response = okHttpClient.newCall(request).execute();
            result = response.body().string();
            log.info("Get请求返回：{}", result);
            return result;
        } catch (Exception e) {
            log.error("OkHttp[Get]请求异常", e);
            return result;
        }
    }

    /**
     * Post请求
     *
     * @param url    URL地址
     * @param params 参数
     * @return 返回结果
     */
    public static String post(String url, Map<String, String> params) {
        String result = null;
        if (params == null) {
            params = new HashMap<String, String>();
        }
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            FormBody.Builder formBodyBuilder = new FormBody.Builder();
            //添加参数
            log.info("params：{}", JSON.toJSONString(params));
            for (Map.Entry<String, String> map : params.entrySet()) {
                String key = map.getKey();
                String value;
                if (map.getValue() == null) {
                    value = "";
                } else {
                    value = map.getValue();
                }
                formBodyBuilder.add(key, value);
            }
            FormBody formBody = formBodyBuilder.build();
            Request request = new Request.Builder().url(url).post(formBody).build();
            Response response = okHttpClient.newCall(request).execute();
            result = response.body().string();
            log.info("Post请求返回：{}", result);
            return result;
        } catch (Exception e) {
            log.error("OkHttp[Post]请求异常", e);
            return result;
        }
    }

    /**
     * 上传文件请求（Post请求）
     *
     * @param url    URL地址
     * @param params 文件 key：参数名 value：文件 （可以多文件）
     * @return 返回结果
     */
    public static String upload(String url, Map<String, File> params) {
        String result = null;
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            MultipartBody.Builder multipartBodyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);

            for (Map.Entry<String, File> map : params.entrySet()) {
                String key = map.getKey();
                File file = map.getValue();
                if (file == null || (file.exists() && file.length() == 0)) {
                    continue;
                }
                multipartBodyBuilder.addFormDataPart(key, file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file));
            }
            RequestBody requestBody = multipartBodyBuilder.build();
            Request request = new Request.Builder().url(url).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            result = response.body().string();
            log.info("Upload请求返回：{}", result);
            return result;
        } catch (Exception e) {
            log.error("OkHttp[Upload]请求异常", e);
            return result;
        }
    }

    /**
     * 下载文件请求（Get请求）
     *
     * @param url      URL地址
     * @param savePath 保存路径（包括文件名）
     * @return 文件保存路径
     */
    public static String download(String url, String savePath) {
        String result = null;
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            Request request = new Request.Builder().url(url).build();
            Response response = okHttpClient.newCall(request).execute();
            File file = new File(savePath);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            BufferedSink sink = Okio.buffer((Okio.sink(file)));
            sink.writeAll(response.body().source());
            sink.flush();
            sink.close();
            result = savePath;
            log.info("Download请求返回：{}", result);
            return result;
        } catch (Exception e) {
            log.error("OkHttp[Download]请求异常", e);
            return result;
        }
    }
}
