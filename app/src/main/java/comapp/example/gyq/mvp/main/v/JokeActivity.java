package comapp.example.gyq.mvp.main.v;

import android.graphics.Color;
import android.support.annotation.BoolRes;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.View;

import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import com.orhanobut.logger.Logger;

import butterknife.Bind;
import comapp.example.gyq.mvp.R;
import comapp.example.gyq.mvp.main.adapter.RecyclerAdapters;
import comapp.example.gyq.mvp.main.m.bean.Joke;
import comapp.example.gyq.mvp.main.m.JokeModel;
import comapp.example.gyq.mvp.main.p.JokeContract;
import comapp.example.gyq.mvp.main.p.JokePresenter;
import comapp.example.gyq.mvp.widget.RewriteEasyrecyclerview;
import comapp.example.gyq.mvplibrary.mvplib.view.activity.MVPActivity;
import comapp.example.gyq.mvplibrary.utils.RxBus;
import comapp.example.gyq.mvplibrary.utils.log.SingleClickAspect;
import rx.Subscription;
import rx.functions.Action1;

public class JokeActivity extends MVPActivity<JokeContract.JokeView, JokeModel,
        JokePresenter> implements JokeContract.JokeView {

    private static final String TAG = "zls";

    private static final String PAGE_NUM = "3";

    private static int PAGE_SIZE = 20;

//    @Bind(R.id.listview)
//    ListView mListView;

    //@Bind(R.id.easy_recycler_view)
    @Bind(R.id.rewrite_recycler_view)
    RewriteEasyrecyclerview easyRecyclerView;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

//    private ProgressBar mLoadingBar;

//    private ArrayList<JokeInfo> mJokeInfoArrayList = new ArrayList<>();
//
//    private JokeAdapter mJokeAdapter;
//
//    @Override
//    public int getLayoutResId() {
//        return R.layout.activity_joke;
//    }
//
//    @Override
//    public void initView() {
//        mLoadingBar = (ProgressBar) findViewById(R.id.pressbar);
//        mListView = (ListView) findViewById(R.id.main_page_joke_lv);
//        mJokeAdapter = new JokeAdapter(this, mJokeInfoArrayList);
//        mListView.setAdapter(mJokeAdapter);
//        mPresenter.requestJoke(PAGE_NUM, PAGE_SIZE);
//    }
//
//    @Override
//    public void setJoke(Joke pJoke) {
//        if (pJoke != null) {
//            Joke.Result result = pJoke.getResult();
//            if (result != null) {
//                ArrayList<JokeInfo> jokeInfoArrayList = result.getJokeInfoArrayList();
//                mJokeInfoArrayList.addAll(jokeInfoArrayList);
//                mJokeAdapter.notifyDataSetChanged();
//            }
//        }
//    }

    //    JokeAdapter adapter;
//    List<Joke.ResultBean.ListBean> mDatas;

    private RecyclerAdapters adapter;

    @NonNull
    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }


    @SingleClickAspect("AOP")
    @Override
    protected void initData() {

//        easyRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        easyRecyclerView.setRefreshingColorResources(R.color.colorAccent);
        adapter = new RecyclerAdapters(this);

//        DividerDecoration itemDecoration = new DividerDecoration(Color.GRAY, 1, 0, 0);
//        itemDecoration.setDrawLastItem(true);
//        easyRecyclerView.addItemDecoration(itemDecoration);

        easyRecyclerView.setListenerImpl(adapter, new RewriteEasyrecyclerview.ListenerImpl() {
            @Override
            public void onRefresh() {
                loadData(true);
            }

            @Override
            public void onLoadMore() {
                loadData(false);
            }
        });

        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Joke.ResultBean.ListBean bean = adapter.getItem(position);
                Log.d(TAG, bean.getUrl());
            }
        });


        resultData();

        loadData(true);

        toolbar.setTitle("标题");
//        toolbar.setNavigationIcon(R.mipmap.ic_launcher);//设置导航栏图标
        toolbar.setLogo(R.mipmap.ic_launcher);//设置app logo

        toolbar.setTitleMargin(250, 0, 0, 0);


//        toolbar.setRight(View.TEXT_ALIGNMENT_CENTER);

//        toolbar.setRight(getResources((R.string.app_name));

    }

    private void resultData() {
        rxSbscription = RxBus.getInstance().toObservable(Joke.class).subscribe(new Action1<Joke>() {
            @Override
            public void call(Joke joke) {
                try {
                    if (adapter.getAllData().containsAll(joke.getResult().getList())) {
                        Log.d(TAG, "数据相同");
                    } else {
                        adapter.addAll(joke.getResult().getList());
                        adapter.notifyDataSetChanged();
                    }
                } catch (Exception e) {
                    Logger.i("zls", e.toString());
                }
            }
        });

        rxSbscription = RxBus.getInstance().toObservable(String.class).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Logger.i("zls", s);
            }
        });
    }


    private void loadData(@BoolRes boolean flag) {
        if (flag) {
            PAGE_SIZE = 20;
            adapter.clear();
        } else {
            PAGE_SIZE += 20;
        }
        presenter.requestJoke(PAGE_NUM, PAGE_SIZE + "");
    }

    private Subscription rxSbscription;

    @Override
    protected void onDestroy() {
        if (!rxSbscription.isUnsubscribed()) {
            rxSbscription.unsubscribe();
        }
        super.onDestroy();
    }

    @Override
    public void setJoke(Joke pJoke) {

    }

    @Override
    public void showLoading() {
        showDialog();
    }

    @Override
    public void hideLoading() {
        dismissDialog();

        adapter.stopMore();
    }

    @Override
    public void showError() {
        Snackbar snackbar = Snackbar.make(easyRecyclerView, "网络不好，请过一会再试", Snackbar.LENGTH_LONG).setAction("重试", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.i("重试");
                presenter.requestJoke(PAGE_NUM, PAGE_SIZE + "");
            }
        });
        snackbar.getView().setBackgroundColor(Color.RED);
        snackbar.show();
    }
}
