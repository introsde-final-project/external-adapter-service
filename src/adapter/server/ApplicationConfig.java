package adapter.server;

import adapter.ExceptionListener;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by bishruti on 12/23/15.
 */

@ApplicationPath("adapter")
public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig () {
        packages("adapter");
        register(ExceptionListener.class);
    }
}
