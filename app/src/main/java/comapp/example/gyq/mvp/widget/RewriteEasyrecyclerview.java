package comapp.example.gyq.mvp.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;

import comapp.example.gyq.mvp.R;


/**
 * Created by zkw on 2017/3/31.
 */

public class RewriteEasyrecyclerview extends EasyRecyclerView {

    public RewriteEasyrecyclerview(Context context) {
        this(context, null);
    }

    public RewriteEasyrecyclerview(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RewriteEasyrecyclerview(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        initStytle();
    }


    private void initStytle() {
        super.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerDecoration dividerDecoration = new DividerDecoration(Color.GRAY, 1, 0, 0);
        dividerDecoration.setDrawLastItem(true);
        super.addItemDecoration(dividerDecoration);
    }

    public void setListenerImpl(final RecyclerView.Adapter adapter, final ListenerImpl listenerimpl) {
        super.setAdapter(adapter);

        RecyclerArrayAdapter recyclerarrayadapter = (RecyclerArrayAdapter) adapter;

        recyclerarrayadapter.setError(R.layout.foot_error_data);
        recyclerarrayadapter.setNoMore(R.layout.foot_no_data);
        recyclerarrayadapter.setMore(R.layout.foot_loading_data,
                new RecyclerArrayAdapter.OnLoadMoreListener() {
                    @Override
                    public void onLoadMore() {
                        listenerimpl.onLoadMore();
                    }
                });

        setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                listenerimpl.onRefresh();
            }
        });
    }

    public interface ListenerImpl extends android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener,
            RecyclerArrayAdapter.OnLoadMoreListener {
    }

}
