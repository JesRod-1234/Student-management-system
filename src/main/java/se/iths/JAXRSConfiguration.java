package se.iths;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("api/v1")  // Här kan man sätta en grundläggande applcation path. Vilket i detta fallet är api/v1.
public class JAXRSConfiguration extends Application {

    // Öppnar port med Payara configuration
    // Den här måste finnas med i ett JAVA EE applikation.
}

