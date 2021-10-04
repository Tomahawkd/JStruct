package io.tomahawkd.jstruct.xml.compile;

import io.tomahawkd.jstruct.xml.types.*;
import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.ExpressionEvaluator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class StructXmlParserTest {

    private StructXmlParser parser;

    @Before
    public void init() {
        parser = new StructXmlParser();
    }

    @Test
    public void parse() throws JAXBException {
        Definition d = parser.parseFromResource("basic_test.xml");
        Assert.assertNotNull(d);
        List<Object> content = d.getContent();
        Assert.assertEquals(3, content.size());
        Assert.assertEquals(Block.class, content.get(0).getClass());
        Assert.assertEquals(Block.class, content.get(1).getClass());
        Assert.assertEquals(Sequence.class, content.get(2).getClass());

        Block block1 = (Block) content.get(0);
        Assert.assertEquals("test1", block1.getName());
        List<Object> content1 = block1.getChildren();
        Assert.assertEquals(2, content1.size());
        Element element1 = (Element) content1.get(0);
        Assert.assertEquals("boolean", element1.getName());
        Assert.assertEquals(0L, element1.getOffset().longValue());
        Assert.assertEquals(1L, element1.getLength().longValue());
        Assert.assertEquals(Type.BOOLEAN, element1.getType());
        Element element2 = (Element) content1.get(1);
        Assert.assertEquals("int4", element2.getName());
        Assert.assertEquals(1L, element2.getOffset().longValue());
        Assert.assertEquals(4L, element2.getLength().longValue());
        Assert.assertEquals(Type.INT_4, element2.getType());

        Block block2 = (Block) content.get(1);
        Assert.assertEquals("test2", block2.getName());
        List<Object> content2 = block2.getChildren();
        Assert.assertEquals(1, content2.size());
        Element element3 = (Element) content2.get(0);
        Assert.assertEquals("int8", element3.getName());
        Assert.assertEquals(0L, element3.getOffset().longValue());
        Assert.assertEquals(8L, element3.getLength().longValue());
        Assert.assertEquals(Type.INT_8, element3.getType());

        Sequence sequence = (Sequence) content.get(2);
        Assert.assertEquals("testSeq1", sequence.getName());
        Assert.assertEquals(2, sequence.getBlock().size());
        Block blockRef1 = sequence.getBlock().get(0);
        Assert.assertEquals("test1", blockRef1.getRef());
        Block blockRef2 = sequence.getBlock().get(1);
        Assert.assertEquals("test2", blockRef2.getRef());
    }

}