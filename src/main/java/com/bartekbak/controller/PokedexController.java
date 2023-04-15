package com.bartekbak.controller;

import com.bartekbak.client.PokeGQLClient;
import com.bartekbak.model.PokemonDetailedResponseData;
import com.bartekbak.model.PokemonResponseData;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import reactor.core.publisher.Mono;

@Controller("/pokedex")
public class PokedexController {

    private final PokeGQLClient pokeGQLClient;

    public PokedexController(PokeGQLClient pokeGQLClient) {
        this.pokeGQLClient = pokeGQLClient;
    }

    @Get("/all")
    Mono<PokemonResponseData> getAll() {
        return pokeGQLClient.getAll();
    }

    @Get("/pokemon/{id}")
    Mono<PokemonResponseData> getPokemonById(int id) {
        return pokeGQLClient.getPokemonById(id);
    }

    @Get("/pokemon/detailed/{name}")
    Mono<PokemonDetailedResponseData> getDetailedPokemonByName(String name) {
        return pokeGQLClient.getDetailedPokemonByName(name);
    }

}
