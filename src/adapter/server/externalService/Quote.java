package adapter.server.externalService;

import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * Created by bishruti on 12/25/15.
 */
public class Quote {
    Quote quote = new Quote();
    private static WebTarget service;
    private static Response response;

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://quotesondesign.com/api/3.0/api-3.0.json").build();
    }

    public static String getQuote() {
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        service = client.target(getBaseURI());
        response = service.request().accept(MediaType.APPLICATION_JSON).get();
        System.out.println(response);
        String quote = response.readEntity(String.class);
        System.out.println(quote);
        /*JSONObject jsonObj = new JSONObject(quote);
        String quotation = jsonObj.get("quote").toString();
        System.out.println(quotation);*/
        return quote;
    }
}
