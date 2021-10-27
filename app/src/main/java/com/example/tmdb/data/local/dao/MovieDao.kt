package com.example.tmdb.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.tmdb.data.local.model.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert(onConflict = REPLACE)
    suspend fun save(movie: Movie)

    @Query("SELECT * FROM movie WHERE id = :movieId")
    suspend fun load(movieId: Int): Flow<Movie>
}
