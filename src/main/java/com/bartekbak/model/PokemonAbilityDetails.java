package com.bartekbak.model;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class PokemonAbilityDetails {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
