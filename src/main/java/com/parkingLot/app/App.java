package com.parkingLot.app;

// import the rest service you created!

import com.parkingLot.rest.Rest;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
public class App extends Application {
    private Set<Object> singletons = new HashSet<Object>();
    public App() {
        // Register our hello service
        singletons.add(new Rest());
    }
    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}