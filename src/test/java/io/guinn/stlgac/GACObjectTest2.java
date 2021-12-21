package io.guinn.stlgac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class GACObjectTest2 extends GACObject {

    @Test
    public void testNoPropertiesFileDoesNotThrowException() {
        assertNull(getProperty("invalid"));
    }
}
