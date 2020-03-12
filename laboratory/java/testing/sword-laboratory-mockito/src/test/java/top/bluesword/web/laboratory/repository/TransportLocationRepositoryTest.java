package top.bluesword.web.laboratory.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import top.bluesword.web.laboratory.model.TransportLocation;
import top.bluesword.web.laboratory.service.TransportLocationService;
import top.bluesword.web.laboratory.service.impl.TransportLocationServiceImpl;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TransportLocationRepositoryTest {

    private static TransportLocationService transportLocationService;

    @BeforeAll
    static void setUp(){
        TransportLocationRepository transportLocationRepositoryMock = mock(TransportLocationRepository.class);
        transportLocationService = new TransportLocationServiceImpl(transportLocationRepositoryMock);
        when(transportLocationRepositoryMock.findById("1")).thenReturn(Optional.of(mock(TransportLocation.class)));
    }

    @Test
    void findById(){
        Optional<TransportLocation> byId = transportLocationService.findById("1");
        System.out.println(byId.orElseThrow().getTransportLocationId());
    }

}