package com.liuxinyuchn.simple.httpserver.connector;

import com.sun.net.httpserver.Headers;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author liuxinyuchn
 * @date 2024/8/22 9:42
 */
public interface HttpExchangeResponse {

    Headers getResponseHeaders();

    void sendResponseHeaders(Integer responseCode, Long responseLength) throws IOException;

    OutputStream getResponseBody();
}
