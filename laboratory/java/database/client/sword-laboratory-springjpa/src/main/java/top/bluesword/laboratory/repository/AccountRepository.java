package top.bluesword.laboratory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.bluesword.laboratory.domain.Account;

/**
 * @author 李林峰
 */
@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
}
