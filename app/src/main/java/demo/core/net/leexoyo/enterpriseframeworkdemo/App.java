package demo.core.net.leexoyo.enterpriseframeworkdemo;

import android.app.Application;

import core.net.leexoyo.BaseConfig;

/**
 * Created by CHEUNG on 2018/8/8.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        BaseConfig.getInstance(this).init(true);
    }
}
