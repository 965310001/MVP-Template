package comapp.example.gyq.mvp.main.p;

import comapp.example.gyq.mvp.Contract.BaseContract;
import comapp.example.gyq.mvp.main.v.MVPListener;
import comapp.example.gyq.mvp.main.m.bean.Joke;
import comapp.example.gyq.mvplibrary.mvplib.model.IModel;
import comapp.example.gyq.mvplibrary.mvplib.presenter.BasePresenter;
import comapp.example.gyq.mvplibrary.mvplib.view.iview.IView;

public class JokeContract extends BaseContract {

//    interface DataView extends IView<DataPresenter> {
//        void showFragment(BaseFragment fragment);
//    }
//    interface DataPresenter extends BasePresenter {
//        void switchToDataList();
//        void switchToDataTree();
//    }
//    interface DataListView extends BaseView<DataListPresenter> {
//        void showDataList(List<String> data);
//    }
//    interface DataListPresenter extends BasePresenter {
//        void loadDataList();
//    }
//    interface DataTreeView extends BaseView<DataTreePresenter> {}
//    interface DataTreePresenter extends BasePresenter {}

    public interface JokeView extends IView {
        void setJoke(Joke pJoke);
    }

    public interface JokeModel extends IModel {
        void requestJoke(String pNum, String pSize, MVPListener pMVPListener);
    }

    public abstract static class JokePresenter extends BasePresenter<JokeView,
            comapp.example.gyq.mvp.main.m.JokeModel> {
        public abstract void requestJoke(String pNum, String pSize);
    }


}