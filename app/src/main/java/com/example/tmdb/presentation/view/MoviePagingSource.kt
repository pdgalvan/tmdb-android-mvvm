package com.example.tmdb.presentation.view

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.tmdb.data.remote.model.GetMovieByIdResponse
import com.example.tmdb.domain.usecase.GetMovieListUseCase
import com.example.tmdb.util.Constants.DEFAULT_PAGE_NUMBER
import retrofit2.HttpException
import java.io.IOException

class MoviePagingSource(private val getMovieListUseCase: GetMovieListUseCase)
    : PagingSource<Int, GetMovieByIdResponse>(){

    override fun getRefreshKey(state: PagingState<Int, GetMovieByIdResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GetMovieByIdResponse> {
        val pageNumber = params.key ?: DEFAULT_PAGE_NUMBER
        val nextPageNumber = pageNumber + 1
        return try{
            val response = getMovieListUseCase.invoke(pageNumber)
            LoadResult.Page(
                data = response.orEmpty(),
                prevKey = null,
                nextKey = nextPageNumber
            )
        }catch (exception: IOException){
            return LoadResult.Error(exception)
        }catch (exception: HttpException){
            return LoadResult.Error(exception)
        }

    }

}
