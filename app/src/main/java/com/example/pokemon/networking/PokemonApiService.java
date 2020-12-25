package com.example.pokemon.networking;

import com.example.pokemon.pojo.PokemonResponse;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface PokemonApiService {

    @GET("pokemon")
    Observable<PokemonResponse> getPokemon();

}
