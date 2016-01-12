package adapter.server.resources;

import adapter.server.externalService.FoodRecommendation;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by bishruti on 12/24/15.
 */

@Stateless // Used only if the the application is deployed in a Java EE container
@LocalBean // Used only if the the application is deployed in a Java EE container

@Path("/foodrecomm")

public class FoodRecommResource {
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getFoodRecomm() {
        return FoodRecommendation.getFoodRecomm();
    }
}