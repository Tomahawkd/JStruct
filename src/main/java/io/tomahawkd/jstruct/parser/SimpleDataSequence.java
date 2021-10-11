package io.tomahawkd.jstruct.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Map;

public class SimpleDataSequence extends AbstractDataSequence {

    private static final Logger logger = LogManager.getLogger(SimpleDataSequence.class);

    private final Map<String, Range> offsetMap;
    private final ByteBuffer buffer;
    private ByteOrder order = ByteOrder.nativeOrder();

    public SimpleDataSequence(String name, Map<String, Range> offsetMap, byte[] data) {
        super(name);
        this.offsetMap = offsetMap;
        this.buffer = ByteBuffer.wrap(data);
    }

    public SimpleDataSequence(String name, Map<String, Range> offsetMap, int capacity) {
        super(name);
        this.offsetMap = offsetMap;
        this.buffer = ByteBuffer.allocate(capacity);
    }

    public void setOrder(ByteOrder order) {
        this.order = order;
    }

    public byte[] getBytesByName(@NotNull String name) {
        Range range = offsetMap.get(name);
        if (range == null) return null;

        if (range.start() > buffer.capacity() || range.end() > buffer.capacity())
            throw new IndexOutOfBoundsException(
                    String.format("The range(%d, %d) exceeds the buffer capacity (%d)",
                            range.start(), range.end(), buffer.capacity()));

        byte[] bytes = new byte[range.length()];
        buffer.order(order).get(bytes, range.start(), range.length());
        return bytes;
    }
}
