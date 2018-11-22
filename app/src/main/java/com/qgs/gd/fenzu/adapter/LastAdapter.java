package com.qgs.gd.fenzu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qgs.gd.fenzu.R;
import com.qgs.gd.fenzu.bean.RightUser;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * date:2018/11/22    12:55
 * author:秦广帅(Lenovo)
 * fileName:LastAdapter
 */
public class LastAdapter extends RecyclerView.Adapter<LastAdapter.MyViewHolder> {

    private Context mContext;
    private List<RightUser.DataBean.ListBean> rightList = new ArrayList<>();
    private lastOnClick mLastOnClick;

    public void setLastOnClick(lastOnClick lastOnClick) {
        mLastOnClick = lastOnClick;
    }

    public interface lastOnClick{
        void click(View view,int position);
    }

    public LastAdapter(Context context, List<RightUser.DataBean.ListBean> rightList) {
        mContext = context;
        this.rightList = rightList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.last, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view,mLastOnClick);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        RightUser.DataBean.ListBean bean = rightList.get(i);
        Picasso.with(mContext).load(bean.getIcon()).into(myViewHolder.image);
        myViewHolder.text.setText(bean.getName());
    }

    @Override
    public int getItemCount() {
        return rightList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView text;

        public MyViewHolder(@NonNull View itemView, final lastOnClick lastOnClick) {
            super(itemView);
            text = itemView.findViewById(R.id.right_text);
            image = itemView.findViewById(R.id.right_image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lastOnClick.click(v,getAdapterPosition());
                }
            });
        }
    }
}
