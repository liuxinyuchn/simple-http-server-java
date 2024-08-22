package com.liuxinyuchn.simple.httpserver.connector;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

/**
 * @author liuxinyuchn
 * @date 2024/8/22 9:43
 */
public class HttpExchangeAdapter implements HttpExchangeRequest, HttpExchangeResponse{

    private final HttpExchange httpExchange;

    public HttpExchangeAdapter(HttpExchange httpExchange) {
        this.httpExchange = httpExchange;
    }

    @Override
    public String getRequestMethod() {
        return this.httpExchange.getRequestMethod();
    }

    @Override
    public URI getRequestURI() {
        return this.httpExchange.getRequestURI();
    }

    @Override
    public Headers getResponseHeaders() {
        return this.httpExchange.getResponseHeaders();
    }

    @Override
    public void sendResponseHeaders(Integer responseCode, Long responseLength) throws IOException {
        this.httpExchange.sendResponseHeaders(responseCode, responseLength);
    }

    @Override
    public OutputStream getResponseBody() {
        return this.httpExchange.getResponseBody();
    }
}
