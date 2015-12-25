package adapter.client;

import org.glassfish.jersey.client.ClientConfig;
import org.json.JSONObject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

/**
 * Created by bishruti on 12/25/15.
 */
public class Quote {
    Quote quote = new Quote();
    private static WebTarget service;
    private static Response response;

    public static void main(String[] args) throws IOException {
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        service = client.target(getBaseURI());
        Quote.getQuote();
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://quotesondesign.com/api/3.0/api-3.0.json").build();
    }

    public static String getQuote() {
        response = service.request().accept(MediaType.APPLICATION_JSON).get();
        String quote = response.readEntity(String.class);
        JSONObject jsonObj = new JSONObject(quote);
        String quotation = jsonObj.get("quote").toString();
        System.out.println(quotation);
        return quotation;
    }
}
