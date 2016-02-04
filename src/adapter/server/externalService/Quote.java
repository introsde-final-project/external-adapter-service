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
 * Created by bishruti on 12/25/15.
 */
public class Quote {
    Quote quote = new Quote();
    private static WebTarget service;
    private static Response response;

    /* Establish connection with external Quote service. */

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://quotesondesign.com/api/3.0/api-3.0.json").build();
    }

    /*  Request to obtain quote.
        Expected Input: -
        Expected Output: Quote (String) */

    public static String getQuote() throws IOException {
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        BufferedWriter bufferedWriter;
        service = client.target(getBaseURI());

        File log = new File("././quotation.log");
        FileWriter fileWriter = new FileWriter(log.getAbsoluteFile());
        bufferedWriter = new BufferedWriter(fileWriter);
        printAndSaveInLog(bufferedWriter, "External Service URL: " + service.getUri());
        printAndSaveInLog(bufferedWriter, "\n");

        response = service.request().accept(MediaType.APPLICATION_JSON).get();
        String quote = response.readEntity(String.class);
        printAndSaveInLog(bufferedWriter, quote);
        bufferedWriter.close();
        return quote;
    }

    /* Method to save the contents in log file */

    private static void printAndSaveInLog(BufferedWriter bufferwriter, String outputResponse) throws IOException {
        bufferwriter.write(outputResponse + "\n");
    }
}
