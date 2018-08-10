package core.net.leexoyo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by CHEUNG on 2018/8/10.
 * 通用框架基类
 */
public abstract class BaseFragment extends Fragment {
    private Unbinder unbinder;
    protected Activity mActivity;

    protected abstract int getContentViewId();
    protected abstract void initUI(View view);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mActivity = getActivity();
        View parentView = inflater.inflate(getContentViewId(), container, false);
        unbinder = ButterKnife.bind(this,parentView);
        initUI(parentView);
        return parentView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
