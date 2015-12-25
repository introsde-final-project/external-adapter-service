package adapter.server;

import adapter.ExceptionListener;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by bishruti on 12/23/15.
 */

public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig () {
        packages("ehealth");
        register(ExceptionListener.class);
    }
}
