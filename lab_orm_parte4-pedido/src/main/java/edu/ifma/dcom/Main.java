package edu.ifma.dcom;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab_jpa");

        System.out.println(factory.getProperties() );

        factory.close();

    }
}