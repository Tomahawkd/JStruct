package io.tomahawkd.jstruct.exceptions;

public class DuplicatedException extends IllegalArgumentException {

    public DuplicatedException() {
    }

    public DuplicatedException(String s) {
        super(s);
    }

    public DuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicatedException(Throwable cause) {
        super(cause);
    }
}
