package com.bartekbak.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public class PokemonDetailed {
    private String id;
    private String name;
    private int weight;
    @JsonProperty("pokemon_v2_pokemonabilities")
    List<PokemonAbility> abilitiesList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<PokemonAbility> getAbilitiesList() {
        return abilitiesList;
    }

    public void setAbilitiesList(List<PokemonAbility> abilitiesList) {
        this.abilitiesList = abilitiesList;
    }
}
