package org.training.samples.exceptions;

public class Main {

    public static void main(String[] args) {
        try {

            angelFunction();
        } catch (CustomUncheckedException e) {

            System.out.println("main hiba");
            System.out.println("user: "+ e.getUser());
        }
        System.out.println("After angel");
    }



    private static void angelFunction() {
        evilFunction();
    }

    private static void evilFunction()  {
        // Valami logika...

        throw new CustomUncheckedException("Hiba", "user1");

    }

}
