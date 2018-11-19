package com.parkingLot.rest;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.parkingLot.app.Ticket;
import com.parkingLot.dao.TicketDao;


import java.util.List;


@Path("/")
public class Rest {



    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ticket> getAll()  {

        TicketDao t = new TicketDao();


        return t.retrieveAll();

    }

        @GET
        @Path("/lost")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Ticket> lostTicket()  {

            TicketDao t = new TicketDao();


            return t.retrieveLost();

    }

    @POST
    @Path("/getTicket")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ticket> getTicket(Ticket posted)  {


        return null;



    }

    @GET
    @Path("/updateTicket")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ticket> updateTicket()  {

        return null;

    }






}
    
