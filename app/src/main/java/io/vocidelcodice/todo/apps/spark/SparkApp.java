package io.vocidelcodice.todo.apps.spark;

import static spark.Spark.*;

public class SparkApp {

    public static void main(String[] args) {
        get("/hello", (request, response) -> "Hello world!");
    }
}
