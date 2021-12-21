package io.guinn.stlgac;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class GACApplication extends GACObject {

    @PostConstruct
    private void init() {
        log.debug("Constructed application singleton.");
    }
}
