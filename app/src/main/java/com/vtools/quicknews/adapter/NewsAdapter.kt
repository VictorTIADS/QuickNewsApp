package com.vtools.quicknews.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vtools.quicknews.R
import com.vtools.quicknews.model.Article
import com.vtools.quicknews.model.Request
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(val context:Context,val mNews:Request) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val new = mNews.articles[position]
        val image = holder.itemView.item_list_image
        val title = holder.itemView.item_list_title
        Picasso.get().load(new.urlToImage).resize(1500,1500).into(image)
        title.text = new.title
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_news,parent,false)
        return ViewlHolder(view)
    }

    override fun getItemCount() = mNews.articles.size
}
class ViewlHolder(val itemView: View) : RecyclerView.ViewHolder(itemView)

