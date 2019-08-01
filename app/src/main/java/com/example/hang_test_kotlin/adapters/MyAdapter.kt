package com.example.hang_test_kotlin.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.hang_test_kotlin.R
import com.example.hang_test_kotlin.bean.DataBeen

class MyAdapter(var list: List<DataBeen.ResultsBean>, var context: Context) : RecyclerView.Adapter<MyAdapter.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val inflate = LayoutInflater.from(context).inflate(R.layout.mai_item, null, false)
        return  ViewHolder(inflate);
    }

    override fun getItemCount(): Int {
            return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, postion: Int) {
        val bean = list.get(postion)
            holder.txt.text=bean.desc
        Glide.with(context).load(bean.url).apply(RequestOptions.circleCropTransform()).into(holder.img)
    }
    inner class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!) {
             var txt:TextView
            var img:ImageView
        init {
            txt= this.itemView!!.findViewById(R.id.txt)
            img= this.itemView!!.findViewById(R.id.imgs)
        }
    }
}
