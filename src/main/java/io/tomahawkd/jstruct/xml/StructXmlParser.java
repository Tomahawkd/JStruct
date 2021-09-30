package io.tomahawkd.jstruct.xml;

import io.tomahawkd.jstruct.xml.types.Definition;
import io.tomahawkd.jstruct.xml.types.ObjectFactory;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.InputStream;
import java.nio.file.Path;

public class StructXmlParser {

    private Unmarshaller unmarshaller;

    public static StructXmlParser newParser() throws JAXBException, SAXException {
        StructXmlParser parser = new StructXmlParser();
        parser.setupParser();
        return parser;
    }

    public Definition parse(InputStream stream) throws JAXBException {
        return (Definition) this.unmarshaller.unmarshal(stream);
    }

    public Definition parse(Path path) throws JAXBException {
        return (Definition) this.unmarshaller.unmarshal(path.toFile());
    }

    private void setupParser() throws SAXException, JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Definition.class, ObjectFactory.class);
        this.unmarshaller = jc.createUnmarshaller();

        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        InputStream stream = StructXmlParser.class.getClassLoader().getResourceAsStream(Constants.XSD_VALIDATION_FILE);
        if (stream == null) throw new IllegalArgumentException("File not found.");
        this.unmarshaller.setSchema(sf.newSchema(new StreamSource(stream)));
    }
}
