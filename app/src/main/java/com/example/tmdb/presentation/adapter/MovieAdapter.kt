package com.example.tmdb.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdb.R
import com.example.tmdb.data.remote.model.GetMovieByIdResponse

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>(){
    private val movieList = mutableListOf<GetMovieByIdResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(layoutInflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = movieList[position]
        holder.bind(item)
    }

    override fun getItemCount() = movieList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<GetMovieByIdResponse>){
        movieList.clear()
        movieList.addAll(list)
        notifyDataSetChanged()
    }
}
