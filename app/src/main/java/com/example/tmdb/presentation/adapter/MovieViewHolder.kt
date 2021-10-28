package com.example.tmdb.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdb.data.remote.model.GetMovieByIdResponse
import com.example.tmdb.databinding.ItemMovieBinding
import com.example.tmdb.util.Constants.IMAGE_URL

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private val binding = ItemMovieBinding.bind(view)
    fun bind(getMovieByIdResponse: GetMovieByIdResponse){
        binding.tvTitle.text = getMovieByIdResponse.title
        Glide.with(itemView)
            .load(IMAGE_URL.plus(getMovieByIdResponse.posterPath))
            .into(binding.ivMovie)
    }
}
