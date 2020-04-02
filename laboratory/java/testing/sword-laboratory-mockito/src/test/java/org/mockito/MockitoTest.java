package org.mockito;

import org.junit.jupiter.api.Test;
import top.bluesword.web.laboratory.model.TransportLocation;

class MockitoTest {

    @Test
    void spy() {
        System.out.println(Mockito.spy(TransportLocation.class));
    }

}
