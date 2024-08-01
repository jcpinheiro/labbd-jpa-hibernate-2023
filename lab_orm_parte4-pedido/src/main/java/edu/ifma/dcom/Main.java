package edu.ifma.dcom;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab_jpa");
        System.out.println(factory.getProperties() );

        factory.close();

    }
}