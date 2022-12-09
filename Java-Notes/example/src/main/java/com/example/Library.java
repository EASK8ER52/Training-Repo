package com.example;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.javalin.Javalin;

public class Library
{
    public static List<Book> library = new ArrayList<>();

    public static Logger logger = LoggerFactory.getLogger(Library.class);

    public static void main(String[] args)
    {
        // Local Declarations
        logger.trace("This log was created for trace");
        logger.debug("This log was created for debug");
        logger.info("Application Starting!");
        logger.warn("This log was created at the warn level");
        logger.error("This log was created at the error level");
        
        Book startingBook = new Book();
        Javalin app = Javalin.create();
        // Processing
        startingBook.setTitle("The Fellowship of the Ring");
        startingBook.setAuthor("J.R.R. Tolkien");
        startingBook.setGenre("Fantasy");
        startingBook.setIsbn(123456789);

        library.add(startingBook);
        

        app.get("/book/{index}", ctx ->
        {
            int index = Integer.parseInt(ctx.pathParam("index"));
            Book book = library.get(index);
            ctx.json(book);
            ctx.status(200);
        });

        app.post("/book", ctx ->
        {
            Book newBook = ctx.bodyAsClass(Book.class);
            library.add(newBook);
            ctx.result("Book added to the library!");
            ctx.status(201);
        });

        app.patch("/book/{index}", ctx ->
        {
            int index = Integer.parseInt(ctx.pathParam("index"));
            Book updatedBook = ctx.bodyAsClass(Book.class);
            library.get(index).setAuthor(updatedBook.getAuthor());
            library.get(index).setTitle(updatedBook.getTitle());
            library.get(index).setGenre(updatedBook.getGenre());
            ctx.json(library.get(index));
            ctx.status(200);
        });

        app.put("/book/{index}", ctx ->
        {
            int index = Integer.parseInt(ctx.pathParam("index"));
            Book updatedBook = ctx.bodyAsClass(Book.class);
            library.set(index, updatedBook);
            ctx.json(library.get(index));
            ctx.status(200);
        });

        app.delete("/book/{index}", ctx ->
        {
            int index = Integer.parseInt(ctx.pathParam("index"));
            library.remove(index);
            ctx.status(200);
        });

        // Output
        app.start();
    }
}
