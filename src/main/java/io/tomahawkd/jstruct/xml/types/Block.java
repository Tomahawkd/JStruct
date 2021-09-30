package io.tomahawkd.jstruct.xml.types;

import io.tomahawkd.jstruct.xml.Constants;

import java.util.ArrayList;
import java.util.List;

public class Block implements StructType {

    private final String name;
    private final List<StructType> typeList = new ArrayList<>();

    public Block(String name) {
        this.name = name;
    }

    @Override
    public String typeName() {
        return Constants.BLOCK;
    }

    public String name() {
        return name;
    }

    public void addContent(StructType type) {
        typeList.add(type);
    }

    public List<? extends StructType> getContent() {
        return typeList;
    }

    public StructType getByIndex(int index) {
        return typeList.get(index);
    }
}
