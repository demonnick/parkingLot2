package com.parkingLot.db;

import org.flywaydb.core.Flyway;

public class FlywayDB {

    public static void main(String[] args) {


        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:hsqldb:file:C:/Users/fornic01/Desktop/parkingLot/fin/src/main/resources\\PARKING/", "sa", "");
        flyway.migrate();
    }
}
