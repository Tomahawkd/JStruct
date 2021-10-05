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
        List<Block> blocks = d.getBlock();
        Assert.assertEquals(2, blocks.size());
        Assert.assertEquals(Block.class, blocks.get(0).getClass());
        Assert.assertEquals(Block.class, blocks.get(1).getClass());

        List<Sequence> sequences = d.getSequence();
        Assert.assertEquals(Sequence.class, sequences.get(0).getClass());

        Block block1 = blocks.get(0);
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

        Block block2 = blocks.get(1);
        Assert.assertEquals("test2", block2.getName());
        List<Object> content2 = block2.getChildren();
        Assert.assertEquals(1, content2.size());
        Element element3 = (Element) content2.get(0);
        Assert.assertEquals("int8", element3.getName());
        Assert.assertEquals(0L, element3.getOffset().longValue());
        Assert.assertEquals(8L, element3.getLength().longValue());
        Assert.assertEquals(Type.INT_8, element3.getType());

        Sequence sequence = sequences.get(0);
        Assert.assertEquals("testSeq1", sequence.getName());
        Assert.assertEquals(2, sequence.getBlock().size());
        Block blockRef1 = sequence.getBlock().get(0);
        Assert.assertEquals("test1", blockRef1.getRef());
        Block blockRef2 = sequence.getBlock().get(1);
        Assert.assertEquals("test2", blockRef2.getRef());
    }


    @Test
    public void parse2() throws InvocationTargetException, CompileException {
        ExpressionEvaluator e = new ExpressionEvaluator();
        e.setParameters(new String[] {"$length$"}, new Class[] {int.class});
        e.setExpressionType(boolean.class);
        e.cook("$length$ > 5");
        boolean result = (boolean) e.evaluate(new Object[] {6});
        System.out.println(result);

        e.setExpressionType(int.class);
        e.cook("($length$ - 5) * 4");
        int result2 = (int) e.evaluate(new Object[] {6});
        System.out.println(result2);
    }
}