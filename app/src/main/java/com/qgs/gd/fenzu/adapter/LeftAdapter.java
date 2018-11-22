package com.qgs.gd.fenzu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qgs.gd.fenzu.R;
import com.qgs.gd.fenzu.bean.LeftUser;

import java.util.ArrayList;
import java.util.List;

/**
 * date:2018/11/22    11:18
 * author:秦广帅(Lenovo)
 * fileName:LeftAdapter
 */
public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.MyViewHolder> {

    private Context mContext;
    private List<LeftUser.DataBean> list;
    private leftOnClick mLeftOnClick;

    public void setLeftOnClick(leftOnClick leftOnClick) {
        mLeftOnClick = leftOnClick;
    }

    public LeftAdapter(Context context, List<LeftUser.DataBean> list) {
        mContext = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.left, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view,mLeftOnClick);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.text.setText(list.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView text;

        public MyViewHolder(@NonNull View itemView, final leftOnClick leftOnClick) {
            super(itemView);
            text = itemView.findViewById(R.id.left_text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    leftOnClick.click(v,getAdapterPosition());
                }
            });
        }
    }

    public interface leftOnClick{
        void click(View view,int position);
    }
}
