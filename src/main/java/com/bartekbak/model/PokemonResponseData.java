package com.bartekbak.model;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class PokemonResponseData {
    private PokemonBasicResponse data;


    public PokemonBasicResponse getData() {
        return data;
    }

    public void setData(PokemonBasicResponse data) {
        this.data = data;
    }
}
