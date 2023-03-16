package com.bartekbak.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public class PokemonBasicResponse {

    @JsonProperty("pokemon_v2_pokemon")
    private List<PokemonBasic> pokemonList;

    public List<PokemonBasic> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<PokemonBasic> pokemonList) {
        this.pokemonList = pokemonList;
    }
}
