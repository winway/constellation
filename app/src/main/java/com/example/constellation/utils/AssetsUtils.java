package com.example.constellation.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.constellation.bean.ConstellationBean;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.example.constellation.utils
 * @ClassName: AssetsUtils
 * @Author: winwa
 * @Date: 2023/1/26 16:11
 * @Description:
 **/
public class AssetsUtils {
    private static Map<String, Bitmap> sLogoMap;
    private static Map<String, Bitmap> sCartoonLogoMap;

    public static String getStringFromFile(Context context, String filename) {
        AssetManager assets = context.getResources().getAssets();

        InputStream inputStream = null;
        try {
            inputStream = assets.open(filename);

            int len = 0;
            byte[] buf = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while ((len = inputStream.read(buf)) != -1) {
                byteArrayOutputStream.write(buf, 0, len);
            }

            return byteArrayOutputStream.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public static Bitmap getBitmapFromFile(Context context, String filename) {
        Bitmap bitmap = null;

        AssetManager assets = context.getResources().getAssets();

        try {
            InputStream inputStream = assets.open(filename);
            bitmap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    public static void loadLogo(Context context, ConstellationBean constellationBean) {
        sLogoMap = new HashMap<>();
        sCartoonLogoMap = new HashMap<>();

        List<ConstellationBean.StarinfoBean> starinfo = constellationBean.getStarinfo();
        for (int i = 0; i < starinfo.size(); i++) {
            String logoName = starinfo.get(i).getLogoname();

            Bitmap logoBitmap = getBitmapFromFile(context, "xzlogo/" + logoName + ".png");
            sLogoMap.put(logoName, logoBitmap);

            Bitmap cartoonLogBitmap = getBitmapFromFile(context, "xzcontentlogo/" + logoName + ".png");
            sCartoonLogoMap.put(logoName, cartoonLogBitmap);
        }
    }

    public static Map<String, Bitmap> getLogoMap() {
        return sLogoMap;
    }

    public static Map<String, Bitmap> getCartoonLogoMap() {
        return sCartoonLogoMap;
    }

    public static Bitmap getLogoBitmapFromMap(String logoName) {
        return sLogoMap.get(logoName);
    }

    public static Bitmap getCartoonLogoBitmapFromMap(String logoName) {
        return sCartoonLogoMap.get(logoName);
    }
}
