package com.school.schooldeal.takeout.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;

import com.school.schooldeal.R;
import com.school.schooldeal.base.BaseFragment;
import com.school.schooldeal.commen.util.ScrollAwareFABBehavior;
import com.school.schooldeal.sign.model.StudentUser;
import com.school.schooldeal.takeout.model.TakeOutDataAdapter;
import com.school.schooldeal.takeout.presenter.TakeOutPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;

/**
 * Created by U-nookia on 2016/12/19.
 * 外卖界面的view
 */

public class TakeOutFragment extends BaseFragment
        implements ImplTakeOutFragment {

    @BindView(R.id.takeOutRecycler)
    RecyclerView takeOutRecycler;
    @BindView(R.id.takeout_fab)
    FloatingActionButton mTakeoutFab;

    private TakeOutPresenter presenter;
    private static final Interpolator INTERPOLATOR = new FastOutSlowInInterpolator();

    @Override
    protected void initData() {
        initRecycler();
        presenter = new TakeOutPresenter(getContext(), this);
        presenter.initAdapter();
        if (BmobUser.getCurrentUser(getContext()) instanceof StudentUser){
            mTakeoutFab.setVisibility(View.GONE);
        }
        addOnScrollListener();
    }

    private void initRecycler() {
        takeOutRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected int getResourceId() {
        return R.layout.fragment_takeout;
    }

    @Override
    public void setAdapter(TakeOutDataAdapter adapter) {
        takeOutRecycler.setAdapter(adapter);
    }

    @OnClick(R.id.takeout_fab)
    public void onClick() {
        Intent intent = new Intent(getContext(), TakeoutGenerateActivity.class);
        startActivity(intent);
    }

    //RecyclerView滑动监听
    private void addOnScrollListener(){
        takeOutRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                //
                boolean isSignificantDelta = Math.abs(dy) > 4;
                if (isSignificantDelta) {
                    if (dy > 0) {
                        //向上滑动时隐藏FloatingActionButton
                        mTakeoutFab.hide();
//                        ViewCompat.animate(mTakeoutFab)
//                                .translationY(mTakeoutFab.getHeight() + getMarginBottom(mTakeoutFab))
//                                .setInterpolator(INTERPOLATOR)
//                                .withLayer()
//                                .setListener(null)
//                                .start();
                    } else {
                        //向下滑动时显示FloatingActionButton
                        mTakeoutFab.show();
//                        ViewCompat.animate(mTakeoutFab).translationY(0)
//                               .setInterpolator(INTERPOLATOR)
//                                .withLayer()
//                                .setListener(null)
//                               .start();
                    }
                }
            }
        });
    }

    private int getMarginBottom(View v) {
        int marginBottom = 0;
        final ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginBottom = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        return marginBottom;
    }
}
