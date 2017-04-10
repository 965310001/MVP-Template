package comapp.example.gyq.mvplibrary.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ViewHolder {

	private SparseArray<View> mViews;
//	private Context mContext;
	private View mConvertView;
	private int mPosition;

	protected View getConvertView() {
		return mConvertView;
	}

	public int getPostion() {
		return mPosition;
	}

	public ViewHolder(Context context,int layoutId,ViewGroup parent,int postion) {
		this.mPosition=postion;
//		this.mContext=context;
		mViews=new SparseArray<View>();
		mConvertView=LayoutInflater.from(context).inflate(layoutId, parent,false);
		mConvertView.setTag(this);
	}

	public static ViewHolder get(Context context,int layoutId,ViewGroup parent,int postion,View convertView) {
		if (convertView==null) {
			return new ViewHolder(context, layoutId, parent, postion);
		}else{
			ViewHolder viewHolder=(ViewHolder) convertView.getTag();
			viewHolder.mPosition=postion;
			return viewHolder;
		}
	}

	public <T extends View> T getView(int viewId){
		View view=mViews.get(viewId);
		if (null==view) {
			view=mConvertView.findViewById(viewId);
			mViews.put(viewId, view);
		} 
		return (T)view;
	}

	public ViewHolder setText(int viewId,CharSequence text){
		TextView tv = getView(viewId);
		tv.setText(text);
		return this;
	}


}
