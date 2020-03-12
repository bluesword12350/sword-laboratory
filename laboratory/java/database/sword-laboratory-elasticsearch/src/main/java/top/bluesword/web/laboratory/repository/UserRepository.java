package top.bluesword.web.laboratory.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import top.bluesword.web.laboratory.model.User;

/**
 * @author 李林峰
 */
@Repository
public interface UserRepository extends ElasticsearchRepository<User,String> {

    /**
     * 根据名称搜索
     * @param name 名称
     * @return 返回值
     */
    Iterable<User> findByName(String name);
}
