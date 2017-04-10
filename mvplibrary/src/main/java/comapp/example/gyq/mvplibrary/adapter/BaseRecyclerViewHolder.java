package comapp.example.gyq.mvplibrary.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by zkw on 2017/3/29.
 */

public class BaseRecyclerViewHolder extends BaseViewHolder {

    private SparseArray<View> mViews;
    private Context mContext;
    private View mConvertView;
    private int mPosition;

    protected View getConvertView() {
        return mConvertView;
    }

    public int getPostion() {
        return mPosition;
    }

    public BaseRecyclerViewHolder(Context context, int layoutId, ViewGroup parent, int postion) {
        super(parent);
        this.mPosition = postion;
        this.mContext = context;
        mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(mContext).inflate(layoutId, parent, false);
        mConvertView.setTag(this);
    }

    public BaseRecyclerViewHolder(Context context, int layoutId, ViewGroup parent) {
        super(parent);
//        this.mPosition=postion;
        this.mContext = context;
        mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(mContext).inflate(layoutId, parent, false);
        mConvertView.setTag(this);
    }

    public static BaseRecyclerViewHolder get(Context context, int layoutId, ViewGroup parent) {
//        if (convertView==null) {
        return new BaseRecyclerViewHolder(context, layoutId, parent);
//        }else{
//            BaseRecyclerViewHolder viewHolder=(BaseRecyclerViewHolder) convertView.getTag();
////            viewHolder.mPosition=postion;
//            return viewHolder;
//        }
    }

    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (null == view) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public BaseRecyclerViewHolder setText(int viewId, CharSequence text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }


//    public BaseRecyclerViewHolder(View itemView) {
//        super(itemView);
//    }
}
