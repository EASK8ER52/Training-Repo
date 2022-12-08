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

        app.post("/add", ctx ->
        {
            String newName = ctx.body();
            names.add(newName);
            ctx.result("Congrats you've added a new name to the database");
            ctx.status(201);
        });

        app.get("/person/{num}", ctx ->
        {
            String numAsString = ctx.pathParam("num");
            int num = Integer.parseInt(numAsString);
            String person = names.get(num);
            ctx.result(person);
            ctx.status(200);
        });

        app.get("/protectedGet/{num}", ctx ->
        {
            String numAsString = ctx.pathParam("num");
            int num = Integer.parseInt(numAsString);
            try
            {
                String person = names.get(num);
                ctx.result(person);
                ctx.status(200);
            }
            catch (IndexOutOfBoundsException e)
            {
                ctx.result("No person found in that index position");
                ctx.status(404);
            }
        });

        app.put("/replace/{num}", ctx ->
        {
            String numString = ctx.pathParam("num");
            int num = Integer.parseInt(numString);
            String replacePerson = ctx.body();
            names.set(num, replacePerson);
            ctx.result("Replaced person successfully!");
            ctx.status(200);
        });

        app.patch("/update/{num}", ctx ->
        {
            String numString = ctx.pathParam("num");
            int num = Integer.parseInt(numString);
            String updatedInformation = ctx.body();
            names.set(num, updatedInformation);
            ctx.result("Successfully updated the person's information");
            ctx.status(200);
        });

        app.delete("/delete", ctx ->
        {
            names.clear();
            ctx.result("All names have been removed from the database");
            ctx.status(200);
        });

        app.start();
    }
}
