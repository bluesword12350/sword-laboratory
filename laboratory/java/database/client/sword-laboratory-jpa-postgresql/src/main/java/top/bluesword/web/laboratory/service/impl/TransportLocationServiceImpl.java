package top.bluesword.web.laboratory.service.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TransportLocationServiceImpl implements TransportLocationService {

    @Autowired
    TransportLocationRepository transportLocationRepository;

    private QTransportLocation qTransportLocation = QTransportLocation.transportLocation;

    @Override
    public Optional<TransportLocation> findById(String id) {
        return transportLocationRepository.findById(id);
    }

    @Override
    public Iterable<TransportLocation> searchByName(String name) {
        BooleanExpression expression = qTransportLocation.transportLocationName.contains(name)
                .or(qTransportLocation.transportLocationNameLocal.contains(name));
        return transportLocationRepository.findAll(expression);
    }

}
