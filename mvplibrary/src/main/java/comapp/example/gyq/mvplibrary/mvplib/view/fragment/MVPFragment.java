package comapp.example.gyq.mvplibrary.mvplib.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import comapp.example.gyq.mvplibrary.mvplib.CreateUtil;
import comapp.example.gyq.mvplibrary.mvplib.IMvpBase;
import comapp.example.gyq.mvplibrary.mvplib.model.IModel;
import comapp.example.gyq.mvplibrary.mvplib.presenter.IPresenter;
import comapp.example.gyq.mvplibrary.mvplib.view.iview.IView;

/**
 * Created by jason on 16/12/2.
 */
//public abstract class MVPFragment<V extends IView, P extends IPresenter<V>> extends Fragment
//        implements IView, IMvpBase<V> {
//    protected P presenter;
//
//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        if (presenter == null) {
//            presenter = createPresenter();
//        }
//
//        presenter.attachView(getMvpView());
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        presenter.detachView(getRetainInstance());
//    }
//
//    protected abstract P createPresenter();
//
//
//    @Nullable
//    @Override
//    public V getMvpView() {
//        return (V) this;
//    }
//}
public abstract class MVPFragment<V extends IView, P extends IPresenter<V, M>, M extends IModel> extends Fragment
        implements IView, IMvpBase<V> {

    protected P presenter;
    public M mModel;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (presenter == null) {
            presenter = CreateUtil.getT(this, 1);
        }
        if (mModel == null) {
            mModel = CreateUtil.getT(this, 2);
        }
        presenter.attachView(getMvpView(), mModel);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detachView(getRetainInstance());
    }

    protected abstract P createPresenter();


    @Nullable
    @Override
    public V getMvpView() {
        return (V) this;
    }
}
