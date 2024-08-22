package com.liuxinyuchn.simple.httpserver.connector;

import java.net.URI;

/**
 * @author liuxinyuchn
 * @date 2024/8/22 9:42
 */
public interface HttpExchangeRequest {

    String getRequestMethod();

    URI getRequestURI();
}
