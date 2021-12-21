package io.guinn.stlgac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GACObjectTest extends GACObject {

    @Test
    public void testObjectHasLoggingAfterConstructor() {
        assertNotNull(log);
    }

    @Test
    public void testLoggerHasChildClassName() {
        assertEquals("io.guinn.stlgac.GACObjectTest", log.getName());
    }

    @Test
    public void testPropertiesHaveBeenLoaded() {
        assertEquals("value", getProperty("key"));
    }

    @Test
    public void testInvalidPropertyDoesNotThrowException() {
        assertNull(getProperty("invalid"));
    }
}
