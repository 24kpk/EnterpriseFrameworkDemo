package core.net.leexoyo;

import android.Manifest;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.Utils;
import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;
import com.orhanobut.logger.LogAdapter;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.Settings;

import java.util.List;

import core.net.leexoyo.constant.BaseConfigConstant;
import core.net.leexoyo.exception.CrashHandler;
import core.net.leexoyo.exception.ICrashProcess;
import core.net.leexoyo.exception.impl.DefaultCrashProcess;
import core.net.leexoyo.utils.Print;
import core.net.leexoyo.utils.SDcardUtil;
import core.net.leexoyo.utils.ToastUtil;

/**
 * Created by CHEUNG on 2018/8/8.
 * 通用框架配置
 */
public class BaseConfig {
    public static final String SP_TAG_BASECONFIG = "SP_TAG_BASECONFIG";
    private static final String LOG_TAG = "BASECONFIG";

    private Context mContext;

    private volatile static BaseConfig sBasicConfig;

    private BaseConfig(Context context){
        this.mContext = context;
        Utils.init(context);
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
     * 仅包含Log日志初始化
     */
    public void init(){
        initLog();
    }


    /**
     * 默认配置
     * 包含Crush日志文件采集
     */
    public void initWithExcepDir(){
        initDir();
        initLog();
        initExceptionHandler();
    }

    /**
     * 设置Log输出控制
     * @param isDebugMode true:打印全部日志，false:不打印日志
     * @return
     */
    public BaseConfig setDebugMode(boolean isDebugMode){
        SPUtils.getInstance(SP_TAG_BASECONFIG).put(BaseConfigConstant.BASE_CONFIG_ISDEBUGMODE,isDebugMode);
        return this;
    }

    /**
     * 初始化SDCard缓存目录
     * <pre>默认根目录名称：当前包名</pre>
     * @return
     */
    public BaseConfig initDir(){
        initDir(mContext.getPackageName());
        return this;
    }

    /**
     * 初始化SDCard缓存目录
     * @param dirName 根目录名称
     * @return
     */
    public BaseConfig initDir(@NonNull final String dirName){
        Acp.getInstance(mContext).request(new AcpOptions.Builder()
                        .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        .build(),
                new AcpListener() {
                    @Override
                    public void onGranted() {
                        SDcardUtil.setRootDirName(dirName);
                        SDcardUtil.initDir();
                    }

                    @Override
                    public void onDenied(List<String> permissions) {
                        Print.e(permissions.toString() + "权限拒绝");
                    }
                });
        return this;
    }

    /**
     * 默认异常信息处理
     * @return
     */
    public BaseConfig initExceptionHandler(){
        return initExceptionHandler(new DefaultCrashProcess(mContext));
    }
    /**
     * 自定义异常信息处理
     * @return
     */
    public BaseConfig initExceptionHandler(ICrashProcess crashProcess){
        CrashHandler.getInstance(crashProcess);
        return this;
    }

    /**
     * 日志打印参数配置
     * @return
     */
    public BaseConfig initLog(){
        initLog(LOG_TAG, null, true, null,true);
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
