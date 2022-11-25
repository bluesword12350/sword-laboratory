package top.bluesword.laboratory.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author 李林峰
 */
@Data
@Entity
public class Identity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "identity_id")
    private List<Role> roles;

}
