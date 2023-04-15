package com.bartekbak.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class PokemonAbility {
    @JsonProperty("pokemon_v2_ability")
    private PokemonAbilityDetails details;

    public PokemonAbilityDetails getDetails() {
        return details;
    }

    public void setDetails(PokemonAbilityDetails details) {
        this.details = details;
    }
}
