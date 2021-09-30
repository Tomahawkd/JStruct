package io.tomahawkd.jstruct.xml.types;

import io.tomahawkd.jstruct.xml.Constants;

public class Padding implements StructType {

    private int offset;
    private int length;
    private int minLength;
    private int maxLength;
    private boolean dynamic;
    private int align;

    @Override
    public String typeName() {
        return Constants.PADDING;
    }
}
