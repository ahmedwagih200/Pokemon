package com.example.pokemon.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.pokemon.pojo.Pokemon;

@Database(entities = Pokemon.class, version = 1,exportSchema = false)
public abstract class DataBase extends RoomDatabase {
    public abstract Dao dao();
}
