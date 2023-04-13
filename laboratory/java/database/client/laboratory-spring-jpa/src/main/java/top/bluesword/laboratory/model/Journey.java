package top.bluesword.laboratory.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * 旅程
 * @author 李林峰
 */
@Data
@Entity
public class Journey {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private OffsetTimeSpan timeSpan;

}
