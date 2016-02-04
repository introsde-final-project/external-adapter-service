package adapter.server.externalService;

import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;

/**
 * Created by bishruti on 12/23/15.
 */

public class FoodRecommendation {

    FoodRecommendation foodRecommendation = new FoodRecommendation();
    private static WebTarget service;
    private static Response response;

    /* Establish connection with external Food Suggestion service and obtains food according to the specified foodType. */

    private static URI getBaseURI(String foodType) {
        return UriBuilder.fromUri("https://api.edamam.com/diet?q=" + foodType + "&app_id=1d272993&app_key=4f73030c1d2d61fe38540936a24a7532").build();
    }

    /*  Request to obtain Food Recommendation.
       Expected Input: FoodType
       Expected Output: Food Recommendation (String) */

    public static String getFoodRecomm(String foodType) throws IOException {
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);

        BufferedWriter bufferedWriter;
        service = client.target(getBaseURI(foodType));

        File log = new File("././food-recomm.log");
        FileWriter fileWriter = new FileWriter(log.getAbsoluteFile());
        bufferedWriter = new BufferedWriter(fileWriter);
        printAndSaveInLog(bufferedWriter, "External Service URL: " + service.getUri());
        printAndSaveInLog(bufferedWriter, "\n");

        response = service.request().accept(MediaType.APPLICATION_JSON).get();
        String foodRecomm = response.readEntity(String.class);
        printAndSaveInLog(bufferedWriter, foodRecomm);
        bufferedWriter.close();

        return foodRecomm;
    }

    /* Method to save the contents in log file */

    private static void printAndSaveInLog(BufferedWriter bufferwriter, String outputResponse) throws IOException {
        bufferwriter.write(outputResponse + "\n");
    }
}
