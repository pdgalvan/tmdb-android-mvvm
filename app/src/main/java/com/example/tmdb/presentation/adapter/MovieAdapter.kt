package com.example.tmdb.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.DifferCallback
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdb.R
import com.example.tmdb.data.remote.model.GetMovieByIdResponse
import javax.inject.Inject

class MovieAdapter @Inject constructor() :
    PagingDataAdapter<GetMovieByIdResponse, MovieViewHolder>(MovieComparator){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(layoutInflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }


    object MovieComparator : DiffUtil.ItemCallback<GetMovieByIdResponse>() {
        override fun areItemsTheSame(oldItem: GetMovieByIdResponse, newItem: GetMovieByIdResponse) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: GetMovieByIdResponse, newItem: GetMovieByIdResponse) =
            oldItem == newItem
    }

}
