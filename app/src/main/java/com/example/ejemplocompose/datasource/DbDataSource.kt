package com.example.ejemplocompose.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ejemplocompose.model.User
import com.example.ejemplocompose.model.UserDao

@Database (entities = [User::class], version = 1)
abstract class DbDataSource : RoomDatabase() {

    abstract fun userDao () : UserDao
}