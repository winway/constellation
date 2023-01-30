package com.example.constellation.common;

import java.net.URLEncoder;

/**
 * @PackageName: com.example.constellation.common
 * @ClassName: URLHelper
 * @Author: winwa
 * @Date: 2023/1/29 8:18
 * @Description:
 **/
public class URLHelper {

    public static String getPartnerURL(String male, String female) {
        try {
            male = URLEncoder.encode(male.replace("座", ""), "UTF-8");
            female = URLEncoder.encode(female.replace("座", ""), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "http://apis.juhe.cn/xzpd/query?men=" + male + "&women=" + female + "&key=1579347413d7e25e11957a999a2b9a3c";
    }

    public static String getLuckURL(String name) {
        try {
            name = URLEncoder.encode(name, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "http://web.juhe.cn/constellation/getAll?consName=" + name + "&type=year&key=6ca64f534bf4e96b4da03090e7d97aa6";
    }
}
