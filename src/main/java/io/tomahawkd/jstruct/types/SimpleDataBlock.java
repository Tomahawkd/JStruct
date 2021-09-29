package io.tomahawkd.jstruct.types;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Map;

public class SimpleDataBlock {

    private static final Logger logger = LogManager.getLogger(SimpleDataBlock.class);

    private final String blockName;
    private final Map<String, Range> offsetMap;
    private final ByteBuffer buffer;
    private ByteOrder order = ByteOrder.nativeOrder();

    public SimpleDataBlock(String blockName, Map<String, Range> offsetMap, byte[] data) {
        this.blockName = blockName;
        this.offsetMap = offsetMap;
        this.buffer = ByteBuffer.wrap(data);
    }

    public SimpleDataBlock(String blockName, Map<String, Range> offsetMap, int capacity) {
        this.blockName = blockName;
        this.offsetMap = offsetMap;
        this.buffer = ByteBuffer.allocate(capacity);
    }

    public void setOrder(ByteOrder order) {
        this.order = order;
    }

    public <T extends StructType> T getTypeByName(@NotNull String name, Class<T> type) {
        Range range = offsetMap.get(name);
        if (range == null) return null;

        if (range.start() > buffer.capacity() || range.end() > buffer.capacity())
            throw new IndexOutOfBoundsException(
                    String.format("The range(%d, %d) exceeds the buffer capacity (%d)",
                            range.start(), range.end(), buffer.capacity()));

    }
}
