package com.parkingLot.rest;



import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.parkingLot.data.service.*;

import java.sql.SQLException;


@Path("/")
public class Rest {

TicketDao t = new TicketDao();

    @GET // This annotation indicates GET request
    @Path("/hello")
    public String hello() {
        try {
            System.out.println(t.retrieveAll());
            return t.retrieveAll().get(0).toString();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}