package com.example.easynotes;

import org.flywaydb.core.Flyway;

import java.net.URI;

public class Migrations {
    public static void main(String[] args) throws Exception{

        Flyway flyway = new Flyway();
        URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();

        flyway.setDataSource(dbUrl, username, password);
        flyway.migrate();
    }
}
