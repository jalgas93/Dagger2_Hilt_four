package com.example.dagger2fourproject.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.dagger2fourproject.cache.model.RoomModel

@Dao
interface RoomServiceDao {

    @Insert
    suspend fun insertRecipe(roomModel: RoomModel):Long

    @Query("SELECT * FROM jalgasDatabase WHERE id = :id")
    suspend fun getRecipeById(id:Int):RoomModel

}