package comapp.example.gyq.mvp.main.adapter;

import android.content.Context;

import java.util.List;
import comapp.example.gyq.mvp.R;
import comapp.example.gyq.mvp.main.m.bean.Joke;
import comapp.example.gyq.mvplibrary.adapter.CommonAdapter;
import comapp.example.gyq.mvplibrary.adapter.ViewHolder;

/**
 * Created by zkw on 2017/3/17.
 */

public class JokeAdapter extends CommonAdapter<Joke.ResultBean.ListBean> {

    public JokeAdapter(Context mcontext, List<Joke.ResultBean.ListBean> mDatas) {
        super(mcontext, mDatas);
    }

    @Override
    protected int initLayoutId() {
        return R.layout.joke_item;
    }

    @Override
    protected void convert(ViewHolder holder, Joke.ResultBean.ListBean joke) {
        holder.setText(R.id.textView1, joke.getAddtime());
        holder.setText(R.id.textView2, joke.getContent());
    }
}
