package core.net.leexoyo.mvp;

/**
 * Created by CHEUNG on 2018/9/11.
 * 抽象为接口
 */
public interface IPresenter<V extends IView> {
    /**
     * 绑定视图
     *
     * @param view
     */
    void attachView(V view);

    /**
     * 解除绑定（每个V记得使用完之后解绑，主要是用于防止内存泄漏问题）
     */
    void dettachView();
}
