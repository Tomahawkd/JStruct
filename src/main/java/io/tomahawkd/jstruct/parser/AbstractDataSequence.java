package io.tomahawkd.jstruct.parser;

public class AbstractDataSequence implements DataSequence {

    protected final String name;

    public AbstractDataSequence(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }
}
