package adapter.server.resources;

import adapter.server.externalService.Quote;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by bishruti on 12/25/15.
 */

@Stateless // Used only if the the application is deployed in a Java EE container
@LocalBean // Used only if the the application is deployed in a Java EE container

@Path("/quote")
public class QuoteResource {
    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    public String getQuote() {
        return  Quote.getQuote();
    }
}
