package com.parkingLot.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.parkingLot.app.Ticket;
import com.parkingLot.dao.TicketDao;

import java.sql.SQLException;
import java.util.List;

//
//@Path("/")
//public class Rest {


//    @GET // This annotation indicates GET request
//    @Path("/hello")
//    public String hello() {
//        try {
//            System.out.println(t.retrieveAll());
//          
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

@Path("/")
public class Rest {



    @GET // This annotation indicates GET request
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ticket> getAll() throws SQLException {

        TicketDao t = new TicketDao();


        return t.retrieveAll();

    }

        @GET // This annotation indicates GET request
        @Path("/lost")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Ticket> hello() throws SQLException {

            TicketDao t = new TicketDao();


            return t.retrieveLost();

    }





}
    
