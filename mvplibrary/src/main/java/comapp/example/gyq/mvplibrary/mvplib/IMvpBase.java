package comapp.example.gyq.mvplibrary.mvplib;


import comapp.example.gyq.mvplibrary.mvplib.view.iview.IView;


public interface IMvpBase<V extends IView> {

    V getMvpView();
}
