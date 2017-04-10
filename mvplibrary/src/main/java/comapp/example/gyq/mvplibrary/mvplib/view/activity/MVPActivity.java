package comapp.example.gyq.mvplibrary.mvplib.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;

import comapp.example.gyq.mvplibrary.baseapp.BaseActivity;
import comapp.example.gyq.mvplibrary.mvplib.CreateUtil;
import comapp.example.gyq.mvplibrary.mvplib.IMvpBase;
import comapp.example.gyq.mvplibrary.mvplib.model.IModel;
import comapp.example.gyq.mvplibrary.mvplib.presenter.IPresenter;
import comapp.example.gyq.mvplibrary.mvplib.view.iview.IView;


public abstract class MVPActivity<V extends IView,M extends IModel, P extends IPresenter<V,M>>
        extends BaseActivity implements IView, IMvpBase<V> {

    protected P presenter;
    protected M mModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mModel = CreateUtil.getT(this, 1);
        presenter = CreateUtil.getT(this, 2);
//
//        //使得P层绑定M层和V层，持有M和V的引用
        presenter.attachView(getMvpView(), mModel);

        initData();
    }

    protected abstract void initData();

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        presenter = createPresenter();
//        presenter = CreateUtil.getT(this, 1);
//        mModel = CreateUtil.getT(this, 2);
//
//        //使得P层绑定M层和V层，持有M和V的引用
//        presenter.attachView(getMvpView(), mModel);
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

//    public abstract P createPresenter();

    @Override
    public V getMvpView() {
        return (V) this;
    }
}
