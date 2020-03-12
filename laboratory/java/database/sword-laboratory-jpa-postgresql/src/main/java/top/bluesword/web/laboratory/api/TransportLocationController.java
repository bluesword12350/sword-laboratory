package top.bluesword.web.laboratory.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.bluesword.web.laboratory.model.TransportLocation;
import top.bluesword.web.laboratory.service.TransportLocationService;

import java.util.Optional;

/**
 * @author 李林峰
 */
@RestController
@RequestMapping("transport/location")
public class TransportLocationController {

    @Autowired
    TransportLocationService transportLocationService;

    @GetMapping("{id}")
    public Optional<TransportLocation> findById(@PathVariable String id){
        return transportLocationService.findById(id);
    }

    @GetMapping("search-by-name")
    public Iterable<TransportLocation> searchByName(String name){
        return transportLocationService.searchByName(name);
    }
}