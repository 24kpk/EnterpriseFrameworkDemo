package demo.core.net.leexoyo.enterpriseframeworkdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import core.net.leexoyo.base.BaseActivity;
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
        Print.d("TextView is "+tv1);
        tv1.setText("冻豆腐故意");
    }

    @OnClick({R.id.tv_main})
    public void onClickView(View view){
        switch (view.getId()){
            case R.id.tv_main:
                ToastUtil.showToast("冻豆腐故意");
                break;
        }
    }

}
