package io.tomahawkd.jstruct.types;

public class Range {

    private final long start;
    private final long length;

    public Range(long start, long length) {
        this.start = start;
        this.length = length;
    }

    public long start() {
        return start;
    }

    public long length() {
        return length;
    }

    public long end() {
        return start + length;
    }
}
