package core.net.leexoyo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.orhanobut.logger.LogAdapter;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.Settings;

import core.net.leexoyo.utils.ToastUtil;

/**
 * Created by CHEUNG on 2018/8/8.
 */
public class BaseConfig {
    private static final String LOG_TAG = BaseConfig.class.getSimpleName();

    private Context mContext;

    private volatile static BaseConfig sBasicConfig;


    private BaseConfig(Context context){
        this.mContext = context;
        ToastUtil.context = context;
    }

    public static final BaseConfig getInstance(@NonNull Context context){
        if(null == sBasicConfig){
            synchronized (BaseConfig.class){
                if(null == sBasicConfig){
                    sBasicConfig = new BaseConfig(context.getApplicationContext());
                }
            }
        }
        return sBasicConfig;
    }


    /**
     * 默认配置
     */
    public void init(boolean isLogDebug){
//        initDir();
        initLog(isLogDebug);
//        initExceptionHandler();
    }

    /**
     * 日志打印参数配置
     * @param isDebug true:打印全部日志，false:不打印日志
     * @return
     */
    public BaseConfig initLog(boolean isDebug){
        initLog(LOG_TAG, null, true, null,isDebug);
        return this;
    }


    /**
     * 日志打印参数配置
     * @param tag 日志标示，可以为空
     * @param methodCount 显示方法行数，默认为：2
     * @param isHideThreadInfo 是否显示线程信息，默认显示
     * @param adapter 自定义log输出
     * @param isDebug true:打印全部日志，false:不打印日志
     * @return
     */
    public BaseConfig initLog(String tag, Integer methodCount,
                               boolean isHideThreadInfo, LogAdapter adapter,
                               boolean isDebug){

        Settings settings = Logger.init(TextUtils.isEmpty(tag) ? LOG_TAG : tag);
        if(null != methodCount){
            settings.methodCount(methodCount);
        }
        if(isHideThreadInfo){
            settings.hideThreadInfo();
        }
        if(null != adapter){
            settings.logAdapter(adapter);
        }
        settings.logLevel(isDebug ? LogLevel.FULL : LogLevel.NONE);
        return this;
    }
}
