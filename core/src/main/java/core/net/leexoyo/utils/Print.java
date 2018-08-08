package core.net.leexoyo.utils;

import com.blankj.utilcode.util.SPUtils;
import com.orhanobut.logger.Logger;

import core.net.leexoyo.BaseConfig;
import core.net.leexoyo.constant.BaseConfigConstant;

/**
 * Created by CHEUNG on 2018/8/8.
 */
public class Print {
    public static void json(String json) {
        if(isDebug())Logger.json(json);
    }
    public static void v(Object log) {if(isDebug()) Logger.v(String.valueOf(log));  }
    public static void d(Object log) {
        if(isDebug()) Logger.d(String.valueOf(log));
    }
    public static void i(Object log) {
        if(isDebug()) Logger.i(String.valueOf(log));
    }
    public static void w(Object log) { if(isDebug()) Logger.w(String.valueOf(log)); }
    public static void e(Object log) { if(isDebug()) Logger.e(String.valueOf(log)); }


    private static boolean isDebug(){
        boolean isDebug = SPUtils.getInstance(BaseConfig.SP_TAG_BASECONFIG).getBoolean(BaseConfigConstant.BASE_CONFIG_ISDEBUGMODE);
        return isDebug;
    }
}
