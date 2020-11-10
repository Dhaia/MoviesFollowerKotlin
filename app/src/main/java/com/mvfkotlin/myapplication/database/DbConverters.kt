package com.mvfkotlin.myapplication.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class DbConverters {
    @TypeConverter
    fun stringToList(string: String): List<Int>{
        val listType: Type = object : TypeToken<List<Int>>() {}.type
        return Gson().fromJson(string, listType)
    }

    @TypeConverter
    fun listToString(list: List<Int>): String{
        return Gson().toJson(list)
    }
}