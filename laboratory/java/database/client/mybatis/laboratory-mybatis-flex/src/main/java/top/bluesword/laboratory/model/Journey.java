package top.bluesword.laboratory.model;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;

/**
 * @author 李林峰
 */
@Data
@Table("journey")
public class Journey {

  @Id
  private Long id;

}
