package com.bartekbak.client;

import com.bartekbak.model.PokemonDetailedResponseData;
import com.bartekbak.model.PokemonResponseData;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.uri.UriBuilder;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;

import java.net.URI;

import static io.micronaut.http.HttpHeaders.ACCEPT;
import static io.micronaut.http.HttpHeaders.USER_AGENT;

@Singleton
public class PokeGQLClient {

    private final HttpClient httpClient;

    public PokeGQLClient(@Client(id = "pokegql") HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public Mono<PokemonResponseData> getAll() {
        String query = """
            {"query":"query Query_root {pokemon_v2_pokemon {id, name}}","variables":{},"operationName":"Query_root"}
            """;

        HttpRequest<String> request = getRequest(query);

        return Mono.from(httpClient.retrieve(request, Argument.of(PokemonResponseData.class)));
    }

    public Mono<PokemonResponseData> getPokemonById(int id) {

        String query = "{\"query\":\"query Query_root($where: pokemon_v2_pokemon_bool_exp) {pokemon_v2_pokemon(where: $where) {id,name}}\",\n";
        String variables = String.format("\"variables\":{\"where\":{\"id\":{\"_eq\":%d}}},%n", id);
        String operationName = "\"operationName\":\"Query_root\"}";

        String fullQuery = query + variables + operationName;

        HttpRequest<String> request = getRequest(fullQuery);
        return Mono.from(httpClient.retrieve(request, Argument.of(PokemonResponseData.class)));
    }

    public Mono<PokemonDetailedResponseData> getDetailedPokemonByName(String name) {
        String abilities = "pokemon_v2_pokemonabilities {pokemon_v2_ability {name}}";
        String fields = String.format("{id,name,weight,%s}", abilities);
        String query = String.format("{\"query\":\"query Query_root($where: pokemon_v2_pokemon_bool_exp) {pokemon_v2_pokemon(where: $where) %s}\",%n", fields);
        String variables = String.format("\"variables\":{\"where\":{\"name\":{\"_eq\":\"%s\"}}},%n", name);
        String operationName = "\"operationName\":\"Query_root\"}";

        String fullQuery = query + variables + operationName;

        HttpRequest<String> request = getRequest(fullQuery);
        return Mono.from(httpClient.retrieve(request, Argument.of(PokemonDetailedResponseData.class)));
    }

    private HttpRequest<String> getRequest(String query) {
        URI uri = UriBuilder.of("/graphql/v1beta")
                .build();

        return HttpRequest.POST(uri, query)
                .header(USER_AGENT, "Micronaut HTTP Client")
                .header(ACCEPT, "application/json");
    }
}
