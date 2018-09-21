package demo.core.net.leexoyo.enterpriseframeworkdemo;

import android.app.Application;

import core.net.leexoyo.BaseConfig;
import core.net.leexoyo.utils.ToastUtil;

/**
 * Created by CHEUNG on 2018/8/8.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtil.context = this.getApplicationContext();

        BaseConfig.getInstance(this).init();
//        BaseConfig.getInstance(this).initWithExcepDir();
        BaseConfig.getInstance(this).setDebugMode(true);
    }
}
