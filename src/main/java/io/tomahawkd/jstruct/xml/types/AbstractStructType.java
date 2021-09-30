package io.tomahawkd.jstruct.xml.types;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStructType implements StructType {

    protected final String name;
    protected final List<StructType> typeList;

    public AbstractStructType(String name) {
        this.name = name;
        this.typeList = new ArrayList<>();
    }

    @Override
    public abstract String typeName();

    public String name() {
        return name;
    }

    public void addContent(StructType type) {
        typeList.add(type);
    }

    public List<? extends StructType> getContent() {
        return typeList;
    }

    public StructType getByIndex(int index){
        return typeList.get(index);
    }
}
