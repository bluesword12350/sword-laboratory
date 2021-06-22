package top.bluesword.laboratory;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author 李林峰
 */
@Data
@Document
public class User {

    private String id;

    private String name;

}
