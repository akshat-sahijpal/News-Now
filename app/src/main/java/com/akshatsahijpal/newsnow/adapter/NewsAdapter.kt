package com.akshatsahijpal.newsnow.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.akshatsahijpal.newsnow.R
import com.akshatsahijpal.newsnow.adapter.vp.FavouritesDataStore
import com.akshatsahijpal.newsnow.data.NewsData
import com.akshatsahijpal.newsnow.databinding.CardNewsItemBinding
import com.bumptech.glide.Glide

class NewsAdapter : PagingDataAdapter<NewsData.Article, NewsAdapter.Holder>(Differentiator) {
    inner class Holder(private var item: CardNewsItemBinding) : RecyclerView.ViewHolder(item.root) {
        fun bind(current: NewsData.Article) {
            item.apply {
                Glide.with(item.root).load(current.urlToImage).centerCrop().into(newsImage)
                newsAuthor.text = current.author
                // newsAtTime.text = current.publishedAt.trimEnd()
                newsHeadlines.text = current.title
                subHeadingNews.text = current.content
                likeButton.setOnClickListener {
                    likeButton.setImageResource(R.drawable.ic_baseline_favorite_24)
                    FavouritesDataStore().save(current)
                }
            }
        }
    }

    companion object {
        var Differentiator = object : DiffUtil.ItemCallback<NewsData.Article>() {
            override fun areItemsTheSame(
                oldItem: NewsData.Article,
                newItem: NewsData.Article
            ): Boolean = oldItem.id1 == newItem.id1

            override fun areContentsTheSame(
                oldItem: NewsData.Article,
                newItem: NewsData.Article
            ): Boolean = oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        var viewer = CardNewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(viewer)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        var current: NewsData.Article? = getItem(position)
        if (current != null) {
            holder.bind(current)
        }
    }
}