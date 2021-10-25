package com.example.tmdb.data.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetMovieListResponse(
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val result: List<GetMovieByIdResponse>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)
