package comapp.example.gyq.mvp.main.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import comapp.example.gyq.mvp.main.m.bean.Joke;

public class RecyclerAdapters extends RecyclerArrayAdapter<Joke.ResultBean.ListBean> {

    public RecyclerAdapters(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProjectViewHolder(parent);
    }

}