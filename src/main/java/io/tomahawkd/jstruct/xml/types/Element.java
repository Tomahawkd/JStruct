package io.tomahawkd.jstruct.xml.types;

import io.tomahawkd.jstruct.xml.Constants;

public class Element implements StructType {

    private String name;
    private int offset;
    private int length;
    private int minLength;
    private int maxLength;
    private String type;
    private Condition condition;
    private boolean dynamic;

    @Override
    public String typeName() {
        return Constants.ELEMENT;
    }
}
