package com.example;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class HelloControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testHelloEndpoint() {
        HttpRequest<String> request = HttpRequest.GET("/hello");
        HttpResponse<String> response = client.toBlocking().exchange(request, String.class);

        assertEquals("Hello, World!", response.body());
    }
}