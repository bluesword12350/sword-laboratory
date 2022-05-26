package javax.xml.bind;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.junit.jupiter.api.Test;
import tob.bluesword.Metadata;

public class XmlMapperTest {

    @Test
    void writeValueAsString() throws JsonProcessingException {
        Metadata metadata = new Metadata();
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(ToXmlGenerator.Feature.WRITE_XML_DECLARATION);
        System.out.println(xmlMapper.writeValueAsString(metadata));
    }

}
