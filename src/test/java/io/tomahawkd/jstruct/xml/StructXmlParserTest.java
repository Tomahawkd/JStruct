package io.tomahawkd.jstruct.xml;

import io.tomahawkd.jstruct.xml.types.Definition;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;

public class StructXmlParserTest {

    @Test
    public void parse() throws JAXBException, SAXException {
        Definition d = StructXmlParser.newParser()
                .parse(this.getClass().getClassLoader().getResourceAsStream("testblock.xml"));
        System.out.println(d);
    }
}