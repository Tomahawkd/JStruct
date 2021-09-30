package io.tomahawkd.jstruct.xml.types;

import io.tomahawkd.jstruct.xml.Constants;

import java.util.ArrayList;
import java.util.List;

public class Sequence implements StructType {

    private final String name;
    private final List<Block> typeList = new ArrayList<>();

    public Sequence(String name) {
        this.name = name;
    }

    @Override
    public String typeName() {
        return Constants.SEQUENCE;
    }

    public String name() {
        return name;
    }

    public void addContent(Block type) {
        typeList.add(type);
    }

    public List<Block> getContent() {
        return typeList;
    }

    public Block getByIndex(int index) {
        return typeList.get(index);
    }
}
