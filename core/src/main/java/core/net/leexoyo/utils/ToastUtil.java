package core.net.leexoyo.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by CHEUNG on 2018/8/8.
 * Toast工具类
 */
public class ToastUtil {
    public static Context context;

    private ToastUtil() {}

    public static void showToast(String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }


    public static void showToast(int resId) {
        Toast.makeText(context, context.getResources().getText(resId),
                Toast.LENGTH_SHORT).show();
    }


    public static void showLongToast(String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }


    public static void showLongToast(int resId) {
        Toast.makeText(context, context.getResources().getText(resId),
                Toast.LENGTH_LONG).show();
    }













    public static void showToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }


    public static void showToast(Context context,int resId) {
        Toast.makeText(context, context.getResources().getText(resId),
                Toast.LENGTH_SHORT).show();
    }


    public static void showLongToast(Context context,String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }


    public static void showLongToast(Context context,int resId) {
        Toast.makeText(context, context.getResources().getText(resId),
                Toast.LENGTH_LONG).show();
    }
}
