package core.net.leexoyo.mvp;

import java.lang.ref.WeakReference;

/**
 * Created by CHEUNG on 2018/9/11.
 * https://blog.csdn.net/z2464342708m/article/details/79374854
 */
public class BasePresenter<V extends IView> implements IPresenter<V> {
    private WeakReference<V> weakView;
//    protected M model;
//
//    public V getView() {
//        return proxyView;
//    }

    /**
     * 用于检查View是否为空对象
     *
     * @return
     */
    public boolean isbindMVPView() {
        return this.weakView != null && this.weakView.get() != null;
    }

    @Override
    public void bindMVPView(V view) {
        this.weakView = new WeakReference<V>(view);
    }

    @Override
    public void unbindMVPView() {
        if (this.weakView != null) {
            this.weakView.clear();
            this.weakView = null;
        }
    }
}
