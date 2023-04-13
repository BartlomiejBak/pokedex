package com.bartekbak.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public class PokemonDetailedResponse {

    @JsonProperty("pokemon_v2_pokemon")
    private List<PokemonDetailed> pokemonList;

    public List<PokemonDetailed> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<PokemonDetailed> pokemonList) {
        this.pokemonList = pokemonList;
    }
}
