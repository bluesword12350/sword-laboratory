package top.bluesword.web.laboratory.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author 李林峰
 */
@Data
@Entity
public class TransportLocation {

    @Id
    public String transportLocationId;

    public String transportLocationName;

    public String transportLocationNameLocal;

}