package com.qgs.gd.fenzu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.qgs.gd.fenzu.adapter.LeftAdapter;
import com.qgs.gd.fenzu.adapter.RightAdapter;
import com.qgs.gd.fenzu.bean.LeftUser;
import com.qgs.gd.fenzu.bean.RightUser;
import com.qgs.gd.fenzu.presenter.LeftPresenter;
import com.qgs.gd.fenzu.presenter.RightPresenter;
import com.qgs.gd.fenzu.url.UrlUtil;
import com.qgs.gd.fenzu.view.LeftView;

import java.util.List;

public class TwoActivity extends AppCompatActivity implements LeftView {

    private RecyclerView recycle1,recycle2;
    private LeftPresenter mLeftPresenter;
    private List<LeftUser.DataBean> mData;
    private List<RightUser.DataBean> mData1;
    private RightPresenter mRightPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        recycle1 = findViewById(R.id.recycle1);
        recycle2 = findViewById(R.id.recycle2);

        mLeftPresenter = new LeftPresenter(this);
        mLeftPresenter.left(UrlUtil.PATH);

        mRightPresenter = new RightPresenter(this);
    }

    @Override
    public void onSuccess(String result) {
        Gson gson = new Gson();
        LeftUser leftUser = gson.fromJson(result, LeftUser.class);
        mData = leftUser.getData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycle1.setLayoutManager(linearLayoutManager);
        LeftAdapter adapter = new LeftAdapter(getApplicationContext(),mData);
        recycle1.setAdapter(adapter);

        adapter.setLeftOnClick(new LeftAdapter.leftOnClick() {
            @Override
            public void click(View view, int position) {
                Toast.makeText(TwoActivity.this,mData.get(position).getName(),Toast.LENGTH_SHORT).show();
                int cid = mData.get(position).getCid();
                mRightPresenter.right(UrlUtil.PATHID+(cid+1));
            }
        });
    }

    @Override
    public void onRightSuccess(String succ) {
        Gson gson = new Gson();
        RightUser rightUser = gson.fromJson(succ, RightUser.class);
        mData1 = rightUser.getData();
        LinearLayoutManager gridLayoutManager =new LinearLayoutManager(this);
        recycle2.setLayoutManager(gridLayoutManager);
        RightAdapter adapter = new RightAdapter(getApplicationContext(),mData1);
        recycle2.setAdapter(adapter);
        adapter.setRightOnClick(new RightAdapter.rightOnClick() {
            @Override
            public void click(View view, int position) {
                Toast.makeText(TwoActivity.this,mData1.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onFailer(String msg) {

    }
}
