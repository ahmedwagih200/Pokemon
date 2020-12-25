package com.example.pokemon.repository;

import androidx.lifecycle.LiveData;

import com.example.pokemon.db.Dao;
import com.example.pokemon.networking.PokemonApiService;
import com.example.pokemon.pojo.Pokemon;
import com.example.pokemon.pojo.PokemonResponse;

import java.util.List;

import javax.inject.Inject;
import io.reactivex.rxjava3.core.Observable;

public class Repository {
    PokemonApiService pokemonApiService ;
    Dao dao;

    @Inject
    public Repository(PokemonApiService pokemonApiService , Dao dao) {
        this.pokemonApiService = pokemonApiService;
        this.dao = dao;
    }

    public Observable<PokemonResponse> getPokemon() {
        return  pokemonApiService.getPokemon();
    }

    public void insertPokemon(Pokemon pokemon){
        dao.insertPokemon(pokemon);
    }

    public void deletePokemon(String pokemonName){
        dao.deletePokemon(pokemonName);}

    public LiveData<List<Pokemon>> getFav(){
        return dao.getPokemon();
    }
}
