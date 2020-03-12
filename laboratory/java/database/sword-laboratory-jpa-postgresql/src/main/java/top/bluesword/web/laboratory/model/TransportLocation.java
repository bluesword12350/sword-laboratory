package top.bluesword.web.laboratory.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 李林峰
 */
@Data
@Entity
@Table(schema = "basic",name = "transport_location")
public class TransportLocation {

    @Id
    public String transportLocationId;

    public String transportLocationName;

    public String transportLocationNameLocal;

}