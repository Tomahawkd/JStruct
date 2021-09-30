package io.tomahawkd.jstruct.xml.types;

import io.tomahawkd.jstruct.xml.Constants;

import java.util.List;

public class Choices implements StructType {

    private String name;
    private int offset;
    private String identifier;
    private List<Block> elements;

    @Override
    public String typeName() {
        return Constants.CHOICES;
    }

    public String getName() {
        return name;
    }

    public int getOffset() {
        return offset;
    }

    public String getIdentifier() {
        return identifier;
    }

    public List<Block> getElements() {
        return elements;
    }
}
