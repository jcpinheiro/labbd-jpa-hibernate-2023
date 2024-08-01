package edu.ifma.dcomp;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pedidovendas");
        System.out.println(factory.getProperties() );

        factory.close();

    }
}