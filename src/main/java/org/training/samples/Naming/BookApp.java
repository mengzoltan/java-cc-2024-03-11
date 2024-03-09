package org.training.samples.Naming;

import org.training.samples.Naming.bookapp.Entity;

import java.math.BigDecimal;
import java.util.UUID;

public class BookApp {

    public static void main(String[] args) {
        Entity entity = new Entity();
        entity.id = UUID.randomUUID().toString();
        entity.name = "Clean Code";
        entity.desc = "An interesting book";
        entity.price = BigDecimal.valueOf(1000.12);
        writeIt(entity);
    }

    private static void writeIt(Entity entity) {
        System.out.println(entity.toString());
        System.out.println("Inserting into db...");
    }

}
