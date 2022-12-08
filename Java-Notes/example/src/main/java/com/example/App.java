package com.example;

import io.javalin.Javalin;

/**
 
 */
public class App 
{
    public static void main( String[] args )
    {
        Javalin app = Javalin.create();

        app.get("/hello", ctx -> ctx.result("Hello World!"));

        app.start();
    }
}
