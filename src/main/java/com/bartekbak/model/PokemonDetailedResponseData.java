package com.bartekbak.model;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class PokemonDetailedResponseData {
    private PokemonDetailedResponse data;

    public PokemonDetailedResponse getData() {
        return data;
    }

    public void setData(PokemonDetailedResponse data) {
        this.data = data;
    }
}
