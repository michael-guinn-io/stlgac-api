package io.guinn.stlgac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GACObjectTest extends GACObject {

    @Test
    public void testObjectHasLoggingAfterConstructor() {
        assertNotNull(log);
    }

    @Test
    public void testLoggerHasChildClassName() {
        assertEquals("io.guinn.stlgac.GACObjectTest", log.getName());
    }
}
