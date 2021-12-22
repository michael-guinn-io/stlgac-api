package io.guinn.stlgac;

public class GACException extends Exception {

    public GACException() {
        super();
    }

    public GACException(String message) {
        super(message);
    }

    public GACException(String message, Throwable cause) {
        super(message, cause);
    }

    public GACException(Throwable cause) {
        super(cause);
    }

    protected GACException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
