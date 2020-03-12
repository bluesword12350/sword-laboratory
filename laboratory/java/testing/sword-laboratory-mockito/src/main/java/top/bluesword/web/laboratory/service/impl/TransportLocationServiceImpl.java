package top.bluesword.web.laboratory.service.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.bluesword.web.laboratory.model.QTransportLocation;
import top.bluesword.web.laboratory.model.TransportLocation;
import top.bluesword.web.laboratory.repository.TransportLocationRepository;
import top.bluesword.web.laboratory.service.TransportLocationService;

import java.util.Optional;

/**
 * @author 李林峰
 */
@Service
@AllArgsConstructor
public class TransportLocationServiceImpl implements TransportLocationService {

    TransportLocationRepository transportLocationRepository;

    private static final QTransportLocation Q_TRANSPORT_LOCATION = QTransportLocation.transportLocation;

    @Override
    public Optional<TransportLocation> findById(String id) {
        return transportLocationRepository.findById(id);
    }

    @Override
    public Iterable<TransportLocation> searchByName(String name) {
        BooleanExpression expression = Q_TRANSPORT_LOCATION.transportLocationName.contains(name)
                .or(Q_TRANSPORT_LOCATION.transportLocationNameLocal.contains(name));
        return transportLocationRepository.findAll(expression);
    }

}
