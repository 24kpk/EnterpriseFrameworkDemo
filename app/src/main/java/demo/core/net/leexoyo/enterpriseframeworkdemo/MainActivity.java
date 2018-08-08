package demo.core.net.leexoyo.enterpriseframeworkdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;

import butterknife.BindView;
import butterknife.OnClick;
import core.net.leexoyo.BaseConfig;
import core.net.leexoyo.base.BaseActivity;
import core.net.leexoyo.constant.BaseConfigConstant;
import core.net.leexoyo.utils.Print;
import core.net.leexoyo.utils.ToastUtil;


public class MainActivity extends BaseActivity {
    @BindView(R.id.tv_main)
    TextView tv1;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initUI(Bundle savedInstanceState) {
        tv1.setText("查看Log输出开关");
    }

    @OnClick({R.id.tv_main})
    public void onClickView(View view){
        switch (view.getId()){
            case R.id.tv_main:
                Print.e("TextView is "+tv1.getText().toString().trim());
                boolean isDebug = SPUtils.getInstance(BaseConfig.SP_TAG_BASECONFIG).getBoolean(BaseConfigConstant.BASE_CONFIG_ISDEBUGMODE);
                ToastUtil.showToast("Log输出开关-->"+isDebug);
                break;
        }
    }

}
