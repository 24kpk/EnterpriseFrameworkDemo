package core.net.leexoyo.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;


/**
 * Created by CHEUNG on 2018/8/8.
 * 通用框架基类
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Context mContext;
    protected Activity mActivity;

    protected abstract int getContentViewId();
    protected abstract void initUI(Bundle savedInstanceState);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());

        ButterKnife.bind(this);

        mContext = this;
        mActivity = this;

        initUI(savedInstanceState);
    }
}
