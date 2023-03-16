package com.bartekbak.client;

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

    private HttpRequest<String> getRequest(String query) {
        URI uri = UriBuilder.of("/graphql/v1beta")
                .build();

        return HttpRequest.POST(uri, query)
                .header(USER_AGENT, "Micronaut HTTP Client")
                .header(ACCEPT, "application/json");
    }

}
