package com.example;

import java.util.ArrayList;
import java.util.List;

import io.javalin.Javalin;

/**
 
 */
public class App 
{
    public static List<String> names = new ArrayList<>();
    public static void main( String[] args )
    {

        // Adding some names to the names list so we can interact 
        names.add("Billy");
        names.add("Sally");
        names.add("Bruce");
        Javalin app = Javalin.create();

        /*
         * the code below tells Javalin that our web server is created needs to be able
         * to handle GET http request that ends with /hello. Upon our application recieving this
         * request the application should return the text "HELLO WORLD" to the application
         */

        app.get("/hello", ctx -> ctx.result("Hello World!"));

        app.post("/add", ctx -> {
            String newName = ctx.body();
            names.add(newName);
            ctx.result("Congrats you've added a new name to the database");
            ctx.status(201);
        });

        app.get("/person/{num}", ctx -> {
            String numAsString = ctx.pathParam("num");
            int num = Integer.parseInt(numAsString);
            String person = names.get(num);
            ctx.result(person);
            ctx.status(200);
        });

        app.start();
    }
}
