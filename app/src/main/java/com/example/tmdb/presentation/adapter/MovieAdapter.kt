package com.example.tmdb.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.tmdb.R
import com.example.tmdb.data.remote.model.GetMovieByIdResponse

class MovieAdapter(private val itemOnClickListener: ItemOnClickListener) :
    PagingDataAdapter<GetMovieByIdResponse, MovieViewHolder>(MovieComparator){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(layoutInflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            itemOnClickListener.onItemClick(getItem(position)?.id ?: 0)
        }
        getItem(position)?.let { holder.bind(it) }
    }


    object MovieComparator : DiffUtil.ItemCallback<GetMovieByIdResponse>() {
        override fun areItemsTheSame(oldItem: GetMovieByIdResponse, newItem: GetMovieByIdResponse) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: GetMovieByIdResponse, newItem: GetMovieByIdResponse) =
            oldItem == newItem
    }

    interface ItemOnClickListener{
        fun onItemClick(movieId: Int)
    }

}
