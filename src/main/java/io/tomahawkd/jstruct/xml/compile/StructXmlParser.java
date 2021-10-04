package io.tomahawkd.jstruct.xml.compile;

import io.tomahawkd.jstruct.exceptions.InternalException;
import io.tomahawkd.jstruct.xml.Constants;
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

    private final Unmarshaller unmarshaller;

    StructXmlParser() {
        try {
            JAXBContext jc = JAXBContext.newInstance(Definition.class, ObjectFactory.class);
            this.unmarshaller = jc.createUnmarshaller();

            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            InputStream stream = StructXmlParser.class.getClassLoader()
                    .getResourceAsStream(Constants.XSD_VALIDATION_FILE);
            if (stream == null) throw new IllegalArgumentException("File not found.");
            this.unmarshaller.setSchema(sf.newSchema(new StreamSource(stream)));
        } catch (JAXBException e) {
            throw new InternalException(InternalException.Type.XML, "JAXB parser setup failed.", e);
        } catch (SAXException e) {
            throw new InternalException(InternalException.Type.XML, "XSD file not valid.", e);
        } catch (IllegalArgumentException e) {
            throw new InternalException(InternalException.Type.XML, "XSD file not found.", e);
        }
    }

    public Definition parseFromResource(String file) throws JAXBException {
        return parse(StructXmlParser.class.getClassLoader().getResourceAsStream(file));
    }

    public Definition parse(InputStream stream) throws JAXBException {
        return (Definition) this.unmarshaller.unmarshal(stream);
    }

    public Definition parse(Path path) throws JAXBException {
        return (Definition) this.unmarshaller.unmarshal(path.toFile());
    }
}
