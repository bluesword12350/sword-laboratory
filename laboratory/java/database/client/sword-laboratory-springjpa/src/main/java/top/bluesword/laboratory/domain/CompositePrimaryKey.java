package top.bluesword.laboratory.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Embeddable
@NoArgsConstructor
public class CompositePrimaryKey implements Serializable {

    private static final long serialVersionUID = 7404958160173288313L;

    private String key1;

    private String key2;

}
