package top.bluesword.laboratory.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author 李林峰
 */
@Data
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private List<Identity> identities;

}
