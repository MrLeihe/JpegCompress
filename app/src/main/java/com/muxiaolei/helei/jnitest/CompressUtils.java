package com.muxiaolei.helei.jnitest;

import android.graphics.Bitmap;
import android.os.Build;

/**
 * @author HeLei
 * @date 2018/3/12 16:55
 */

public class CompressUtils {

    static {
        System.loadLibrary("compress");
    }

    private CompressUtils(){

    }

    public static native boolean compressBitmap(Bitmap bitmap, String dstPath, int quality, boolean isOptimize);

    public static int getBitmapSize(Bitmap bitmap) {
        //API 19
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            return bitmap.getAllocationByteCount() / 1024;
        }
        //API 12
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            return bitmap.getByteCount() / 1024;
        }
        //earlier version
        // 在低版本中用一行的字节x高度
        return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
    }
}
