package io.tomahawkd.jstruct.parser;

public class Range {

    private final int start;
    private final int length;

    public Range(int start, int length) {
        this.start = start;
        this.length = length;
    }

    public int start() {
        return start;
    }

    public int length() {
        return length;
    }

    public int end() {
        return start + length;
    }
}
