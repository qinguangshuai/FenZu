package com.qgs.gd.fenzu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qgs.gd.fenzu.R;
import com.qgs.gd.fenzu.bean.RightUser;

import java.util.List;

/**
 * date:2018/11/22    11:55
 * author:秦广帅(Lenovo)
 * fileName:RightAdapter
 */
public class RightAdapter extends RecyclerView.Adapter<RightAdapter.MyViewHolder> {

    private Context mContext;
    private List<RightUser.DataBean> list;
    private rightOnClick mRightOnClick;

    public void setRightOnClick(rightOnClick rightOnClick) {
        mRightOnClick = rightOnClick;
    }

    public RightAdapter(Context context, List<RightUser.DataBean> list) {
        mContext = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.right, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view,mRightOnClick);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.text.setText(list.get(i).getName());
        GridLayoutManager linearLayoutManager = new GridLayoutManager(mContext,2,RecyclerView.VERTICAL,false);
        myViewHolder.recycle.setLayoutManager(linearLayoutManager);
        LastAdapter lastAdapter = new LastAdapter(mContext,list.get(i).getList());
        myViewHolder.recycle.setAdapter(lastAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView text;
        RecyclerView recycle;

        public MyViewHolder(@NonNull View itemView, final rightOnClick rightOnClick) {
            super(itemView);
            text = itemView.findViewById(R.id.right_text);
            recycle = itemView.findViewById(R.id.recycle3);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rightOnClick.click(v,getAdapterPosition());
                }
            });
        }
    }
    public interface rightOnClick{
        void click(View view,int position);
    }
}
