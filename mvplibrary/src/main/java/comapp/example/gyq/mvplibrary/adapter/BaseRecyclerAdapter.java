package comapp.example.gyq.mvplibrary.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

/**
 * Created by zkw on 2017/3/29.
 */

public abstract  class BaseRecyclerAdapter<T> extends RecyclerArrayAdapter<BaseRecyclerViewHolder> {

    private Context mContext;
    private List<T> mDatas;
//    private LayoutInflater mInlater;
    private int layoutId;

    public BaseRecyclerAdapter(Context mcontext, List<T> mDatas) {
        super(mcontext);
        this.mContext = mcontext;
        this.mDatas = mDatas;
        this.layoutId = initLayoutId();
//        mInlater = LayoutInflater.from(mContext);
    }

    protected abstract int initLayoutId();

    public Context getMcontext() {
        return mContext;
    }


    public void setMcontext(Context mcontext) {
        this.mContext = mcontext;
    }


    public List<T> getmDatas() {
        return mDatas;
    }

    public void setmDatas(List<T> mDatas) {
        this.mDatas = mDatas;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return BaseRecyclerViewHolder.get(mContext, layoutId,
                parent);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        convert(holder, mDatas.get(position));

    }
//    @Override
//    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        BaseRecyclerViewHolder holder=BaseRecyclerViewHolder.get(mContext, layoutId,
//                parent);
//        return holder;
//    }

//    @Override
//    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
//        return null;
//    }

//    @Override
//    public void onBindViewHolder(BaseRecyclerViewHolder holder, int position) {
//        convert(holder, mDatas.get(position));
//    }
//
    protected abstract void convert(BaseViewHolder holder,T t);
//
//    @Override
//    public int getItemCount() {
//        return mDatas.size()==0?0:mDatas.size();
//    }


}
