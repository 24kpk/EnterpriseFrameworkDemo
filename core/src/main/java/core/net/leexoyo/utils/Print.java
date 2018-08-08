package core.net.leexoyo.utils;

import com.orhanobut.logger.Logger;

/**
 * Created by CHEUNG on 2018/8/8.
 */
public class Print {
    public static void json(String json) {
        Logger.json(json);
    }
    public static void v(Object log) {
        Logger.v(String.valueOf(log));
    }
    public static void d(Object log) {
        Logger.d(String.valueOf(log));
    }
    public static void i(Object log) {
        Logger.i(String.valueOf(log));
    }
    public static void w(Object log) {
        Logger.w(String.valueOf(log));
    }
    public static void e(Object log) {
        Logger.e(String.valueOf(log));
    }
}
