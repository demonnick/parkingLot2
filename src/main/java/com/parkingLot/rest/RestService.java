package com.parkingLot.rest;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.parkingLot.data.service.*;

import java.sql.SQLException;
import java.util.List;


@Path("/")
public class RestService {

TodoDataService cry = new TodoDataService();

    @GET // This annotation indicates GET request
    @Path("/hello")
    public String hello() {
        try {
            return cry.retrieveAllTodos().get(0).toString();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}