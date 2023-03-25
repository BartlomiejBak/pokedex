package com.bartekbak.controller

import com.bartekbak.client.PokeGQLClient
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification

@MicronautTest
class PokedexControllerTest extends Specification {

    private PokedexController pokedexController

    private PokeGQLClient pokeGQLClient

    void setup() {
        pokeGQLClient = Mock(PokeGQLClient.class)
        pokedexController = new PokedexController(pokeGQLClient)
    }

    def "should invoke getAll() method"() {
        when: "we invoke getAll() method"
            pokedexController.getAll()

        then: "clients getAll() method should be invoked"
            1 * pokeGQLClient.getAll()
    }

    def "should invoke getPokemonById() method"() {
        when: "we invoke getPokemonById() method"
        pokedexController.getPokemonById(1)

        then: "clients getPokemonById() method should be invoked"
        1 * pokeGQLClient.getPokemonById(1)
    }



}
