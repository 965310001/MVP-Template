package comapp.example.gyq.mvplibrary.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class CommonAdapter<T> extends BaseAdapter{

	private Context mContext;
	private List<T> mDatas;
//	private LayoutInflater mInlater;
	private int layoutId;

	protected CommonAdapter(Context mcontext, List<T> mDatas) {
		this.mContext = mcontext;
		this.mDatas = mDatas;
		this.layoutId = initLayoutId();
//		mInlater = LayoutInflater.from(mContext);
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
	public int getCount() {
		return mDatas.size();
	}

	@Override
	public T getItem(int position) {
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder=ViewHolder.get(mContext, layoutId, parent, position, convertView);
		convert(holder, getItem(position));
		return holder.getConvertView();
	}

	protected abstract void convert(ViewHolder holder,T t);
}
