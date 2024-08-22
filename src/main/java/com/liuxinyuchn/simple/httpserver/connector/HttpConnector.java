package com.liuxinyuchn.simple.httpserver.connector;

import com.liuxinyuchn.simple.httpserver.engine.HttpServletRequestImpl;
import com.liuxinyuchn.simple.httpserver.engine.HttpServletResponseImpl;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.time.LocalDateTime;

/**
 * @author liuxinyuchn
 * @date 2024/8/22 9:41
 */
public class HttpConnector implements HttpHandler, AutoCloseable {

    private static final Logger logger = LoggerFactory.getLogger(HttpConnector.class);

    private final HttpServer server;

    public HttpConnector(String host, int port) throws IOException {
        this.server = HttpServer.create(new InetSocketAddress(host, port), 0, "/", this);
        this.server.start();
        logger.info("Simple HTTP Server started at {}:{}...", host, port);
    }

    @Override
    public void close() {
        this.server.stop(3);
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        var adapter = new HttpExchangeAdapter(exchange);
        var request = new HttpServletRequestImpl(adapter);
        var response = new HttpServletResponseImpl(adapter);
        logger.info("{}: {}?{}", adapter.getRequestMethod(), adapter.getRequestURI().getPath(), adapter.getRequestURI().getQuery());
        try {
            process(request, response);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String html = "<h1>Hello " + (name == null ? "world" : name) + "</h1><p>" + LocalDateTime.now().withNano(0) + "</p>";
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(html);
        out.close();
    }
}
