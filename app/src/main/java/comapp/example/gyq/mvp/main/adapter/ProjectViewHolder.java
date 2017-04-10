package comapp.example.gyq.mvp.main.adapter;

import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import comapp.example.gyq.mvp.R;
import comapp.example.gyq.mvp.main.m.bean.Joke;

class ProjectViewHolder extends BaseViewHolder<Joke.ResultBean.ListBean> {

    private final TextView textView1, textView2;

    public ProjectViewHolder(ViewGroup itemView) {
        super(itemView, R.layout.joke_item);
        textView1 = $(R.id.textView1);
        textView2 = $(R.id.textView2);
    }

    @Override
    public void setData(Joke.ResultBean.ListBean listBean) {
        super.setData(listBean);
        Log.d("ProjectViewHolder", "有数据");
        if (null != listBean) {
            textView1.setText(listBean.getAddtime());
            textView2.setText(listBean.getContent());
        }
    }
}