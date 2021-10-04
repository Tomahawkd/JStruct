package io.tomahawkd.jstruct.exceptions;

public class InternalException extends RuntimeException {

    public static enum Type {
        XML
    }

    private final Type type;

    public InternalException(InternalException.Type type) {
        this(type, (String) null);
    }

    public InternalException(InternalException.Type type, String message) {
        super(message);
        this.type = type;
    }

    public InternalException(InternalException.Type type, Throwable cause) {
        super(cause);
        this.type = type;
    }

    public InternalException(InternalException.Type type, String message, Throwable cause) {
        super(message, cause);
        this.type = type;
    }

    @Override
    public String getMessage() {
        String message = super.getMessage();
        if (message == null) message = "No detailed message.";

        Throwable cause = super.getCause();
        if (cause != this) {
            return String.format("[Component Type: %s] %s Caused By: %s",
                    this.type.name(), message, cause.getClass().getName());
        }

        return String.format("[Component Type: %s] %s", this.type.name(), message);
    }
}
