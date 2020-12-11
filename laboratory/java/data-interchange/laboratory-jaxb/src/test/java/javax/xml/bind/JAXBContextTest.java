package javax.xml.bind;

import org.junit.jupiter.api.Test;
import tob.bluesword.Metadata;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class JAXBContextTest {

    @Test
    void test() throws JAXBException, URISyntaxException {
        URL resource = this.getClass().getClassLoader().getResource("metadata.xml");
        assert resource != null;
        Metadata metadata =
                (Metadata) JAXBContext.newInstance(Metadata.class)
                        .createUnmarshaller()
                        .unmarshal(new File(resource.toURI()));
        System.out.println(metadata);
    }

}
