package adapter.server.resources;

import adapter.server.externalService.Quote;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by bishruti on 12/25/15.
 */

@Stateless // Used only if the the application is deployed in a Java EE container
@LocalBean // Used only if the the application is deployed in a Java EE container

@Path("/quote")

/*  Request to obtain quote.
   Expected Input: -
   Expected Output: Quote (String) */

public class QuoteResource {
    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    public Response getQuote() {
        try {
            return Response.ok(Quote.getQuote()).build();
        } catch(Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}