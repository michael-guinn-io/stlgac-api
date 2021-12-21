package io.guinn.stlgac;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class GACObject {

    protected Logger log = LogManager.getLogger(getClass());

    private Properties properties;

    public GACObject() {

        properties = new Properties();

        String filename = getClass().getSimpleName() + ".properties";

        InputStream inputStream = getClass().getResourceAsStream(filename);
        if (inputStream != null) {
            try (inputStream) {
                properties.load(inputStream);
            } catch (IOException e) {
                log.error("IOException loading properties for class {}: {}", getClass().getSimpleName(), e.getMessage());
            }
        }
    }

    protected String getProperty(String key) {
        return properties.getProperty(key);
    }
}
