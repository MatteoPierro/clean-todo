package io.vocidelcodice.todo.apps.servlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import static org.eclipse.jetty.servlet.ServletContextHandler.SESSIONS;

public class ServletApp {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        server.setHandler(requestHandler());
        server.start();
        server.join();
    }

    private static ServletContextHandler requestHandler() {
        ServletContextHandler requestHandler = new ServletContextHandler(SESSIONS);
        requestHandler.addServlet(HelloServlet.class, "/hello");
        return requestHandler;
    }
}
