package com.example.pokemon.db;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.pokemon.pojo.Pokemon;
import java.util.List;

@androidx.room.Dao
public interface Dao {
    @Insert
    void insertPokemon(Pokemon pokemon);

    @Query("delete from fav_table where name =:pokemonName")
    void deletePokemon(String pokemonName);

    @Query("select * from fav_table")
    LiveData<List<Pokemon>> getPokemon();
}
