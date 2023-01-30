package com.example.constellation.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @PackageName: com.example.constellation.utils
 * @ClassName: HttpUtils
 * @Author: winwa
 * @Date: 2023/1/29 8:21
 * @Description:
 **/
public class HttpUtils {

    public static byte[] getBytesFromUrl(String url) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            URL urlObject = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) urlObject.openConnection();
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();

            int len = 0;
            byte[] buf = new byte[1024];
            while (true) {
                len = inputStream.read(buf);
                if (len == -1) {
                    break;
                }
                byteArrayOutputStream.write(buf, 0, len);
            }
            inputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getStringFromUrl(String url) {
        byte[] bytes = getBytesFromUrl(url);
        if (bytes != null) {
            return new String(bytes);
        }

        return null;
    }
}
