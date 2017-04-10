package comapp.example.gyq.mvp.main.p;

import comapp.example.gyq.mvp.main.v.MVPListener;
import comapp.example.gyq.mvp.main.m.bean.Joke;
import comapp.example.gyq.mvp.main.m.JokeModel;
import comapp.example.gyq.mvplibrary.mvplib.presenter.IPresenter;

/**
 * Created by zkw on 2017/3/17.
 */

public class JokePresenter extends JokeContract.JokePresenter
        implements IPresenter<JokeContract.JokeView, JokeModel> {

    @Override
    public void requestJoke(String pNum, String pSize) {
        final JokeContract.JokeView mView = getView();
        if (mView == null) {
            return;
        }
        mView.showLoading();
        mModel.requestJoke(pNum, pSize, new MVPListener<Joke>() {

            @Override
            public void onSuccess(Joke pJoke) {
                mView.hideLoading();
                mView.setJoke(pJoke);
            }


            @Override
            public void onFinish() {
                mView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                mView.hideLoading();
                mView.showError();
            }
        });
    }
}
