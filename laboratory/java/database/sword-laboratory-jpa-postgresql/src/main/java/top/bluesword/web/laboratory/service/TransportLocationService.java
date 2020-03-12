package top.bluesword.web.laboratory.service;

import top.bluesword.web.laboratory.model.TransportLocation;

import java.util.List;
import java.util.Optional;

/**
 * @author 李林峰
 */
public interface TransportLocationService {

    Optional<TransportLocation> findById(String id);

    Iterable<TransportLocation> searchByName(String name);
}
