package comapp.example.gyq.mvp.main.v;

public interface MVPListener<E> {

    /**
     * 成功的时候回调
     */
    void onSuccess(E pJoke);

    /**
     * 失败的时候回调
     */
    void onError(String msg);

    /**
     * 结束之后回调
     */
    void onFinish();
}