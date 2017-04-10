package comapp.example.gyq.mvplibrary.mvplib.presenter;


import comapp.example.gyq.mvplibrary.mvplib.model.IModel;
import comapp.example.gyq.mvplibrary.mvplib.view.iview.IView;


/**
 * Created by jason on 16/12/2.
 */
public interface IPresenter<V extends IView,M extends IModel> {
//        void attachView(V view);

    void attachView(IView view, IModel pModel);

    void detachView(boolean retainInstance);
    void detachView();
}
