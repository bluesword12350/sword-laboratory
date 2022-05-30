package javax.xml.bind;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.junit.jupiter.api.Test;
import tob.bluesword.Metadata;

import java.util.List;

public class XmlMapperTest {

    @Test
    void writeValueAsString() throws JsonProcessingException {
        Metadata metadata = new Metadata();
        Metadata.Versioning versioning = new Metadata.Versioning();
        Metadata.Versioning.Versions versions = new Metadata.Versioning.Versions();
        versions.setVersion(List.of("1.0.0","1.0.1"));
        versioning.setVersions(versions);
        metadata.setVersioning(versioning);

        XmlMapper xmlMapper = new XmlMapper.Builder(new XmlMapper())
                .defaultUseWrapper(false)
                .enable(ToXmlGenerator.Feature.WRITE_XML_DECLARATION)
                .build();
        System.out.println(xmlMapper.writeValueAsString(metadata));
    }

    @Test
    void readValue() throws JsonProcessingException {
        final String xml = "<?xml version='1.0' encoding='UTF-8'?><Metadata><groupId/><artifactId/><versioning/><ref/></Metadata>";
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        System.out.println(xmlMapper.readValue(xml,Metadata.class));
    }

}
