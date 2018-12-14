package com.wei.wechat.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TokenUtil {

    /**
     * 获取url
     */
    public static void getUrl(String urlStr) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        HttpURLConnection conn = null;
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            InputStream in = conn.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            int len;
            byte[] bytes = new byte[1024];
            while ((len = in.read(bytes)) != -1) {
                byteArrayOutputStream.write(bytes, 0, len);
            }
            System.out.println(new String(byteArrayOutputStream.toByteArray()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (byteArrayOutputStream != null) {
                conn.disconnect();

            }

        }
    }
}
