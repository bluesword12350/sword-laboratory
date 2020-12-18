package top.bluesword.web.laboratory.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author 李林峰
 */
@Data
@Document(indexName="user")
public class User {

    @Id
    private String id;

    private String name;

    private Long createTime;

}
