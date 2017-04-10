package comapp.example.gyq.mvplibrary.mvplib.presenter;

import java.lang.ref.WeakReference;

import comapp.example.gyq.mvplibrary.mvplib.model.IModel;
import comapp.example.gyq.mvplibrary.mvplib.view.iview.IView;

/**
 * MVP基础Presenter
 * Created by jason on 16/12/2.
 */
//public class BasePresenter<V extends IView> implements IPresenter<V> {
//
//    private WeakReference<V> viewRef;
//
//    @Override
//    public void attachView(IView view) {
//        viewRef = new WeakReference<V>((V) view);
//    }
//
//    @Override
//    public void detachView(boolean retainInstance) {
//        if (viewRef != null) {
//            viewRef.clear();
//            viewRef = null;
//        }
//    }
//
//    /**
//     * 获取 presenter 对应的view
//     * @return 如果对应,返回对应实例,否则返回 null
//     */
//    public V getView() {
//        return viewRef == null ? null :viewRef.get();
//    }
//
//    /**
//     * 检查 presenter 是否存在对应View
//     * @return 如果存在返回true, 否则返回false
//     */
//    public boolean isViewAttached() {
//        return viewRef != null && viewRef.get() != null;
//    }
//}

public class BasePresenter<V extends IView, M extends IModel> implements IPresenter<V, M> {

    private WeakReference<V> viewRef;
    protected M mModel;

    public BasePresenter() {
    }

    @Override
    public void attachView(IView view, IModel pModel) {
        viewRef = new WeakReference<>((V) view);
        this.mModel = (M) pModel;
    }

    @Override
    public void detachView(boolean retainInstance) {
        if (null!=viewRef) {
            viewRef.clear();
            viewRef = null;
        }
    }

    //    @Override
//    public void detachView(boolean retainInstance) {
//        if (viewRef != null) {
//            viewRef.clear();
//            viewRef = null;
//        }
//    }

    @Override
    public void detachView() {
        if (null!=viewRef) {
            viewRef.clear();
            viewRef = null;
        }
    }

    /**
     * 获取 presenter 对应的view
     *
     * @return 如果对应, 返回对应实例, 否则返回 null
     */
    public V getView() {
        return viewRef == null ? null : viewRef.get();
    }

    /**
     * 检查 presenter 是否存在对应View
     *
     * @return 如果存在返回true, 否则返回false
     */
    public boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }
}
