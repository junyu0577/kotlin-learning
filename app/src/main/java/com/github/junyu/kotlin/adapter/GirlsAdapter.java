package com.github.junyu.kotlin.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.junyu.kotlin.R;
import com.github.junyu.kotlin.bean.Girls;

import java.util.List;


/**
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/6/11 21:39
 */
public class GirlsAdapter extends RecyclerView.Adapter<GirlsAdapter.ViewHolder> {
    Context context;
    List<Girls.Result> mList;

    public GirlsAdapter(Context context, List<Girls.Result> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.item_girls_image, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setTag(position);
        Girls.Result girls = mList.get(position);
        Glide.with(context).load(girls.getUrl()).into(holder.mImage);
        System.out.println(position+"..."+girls.getUrl());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImage;

        public ViewHolder(View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image_view);
        }
    }
}