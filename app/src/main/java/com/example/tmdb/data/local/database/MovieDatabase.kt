package com.example.tmdb.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tmdb.data.local.model.Movie

@Database(entities = [Movie:: class], version = 1)
abstract class MovieDatabase : RoomDatabase()
