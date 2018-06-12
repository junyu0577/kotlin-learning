package com.github.junyu.kotlin.adapter


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import com.bumptech.glide.Glide
import com.github.junyu.kotlin.R
import com.github.junyu.kotlin.bean.Girls


/**
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/6/11 21:39
 */
class GirlsAdapter(private var context: Context, private var mList: List<Girls.Result>) : RecyclerView.Adapter<GirlsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = View.inflate(context, R.layout.item_girls_image, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tag = position
        val (_, url) = mList[position]
        Glide.with(context).load(url).into(holder.mImage)
    }

    override fun getItemCount(): Int {
        return mList.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var mImage: ImageView

        init {
            mImage = itemView.findViewById(R.id.image_view)
        }
    }
}