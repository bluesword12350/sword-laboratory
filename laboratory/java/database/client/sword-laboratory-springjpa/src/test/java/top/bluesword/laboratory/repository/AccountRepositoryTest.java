package top.bluesword.laboratory.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.bluesword.laboratory.domain.Account;
import top.bluesword.laboratory.domain.Identity;
import top.bluesword.laboratory.domain.Resource;
import top.bluesword.laboratory.domain.Role;

import java.util.List;
import java.util.Optional;

@Slf4j
@SpringBootTest
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void save(){
        Account account = buildAccount();
        accountRepository.save(account);
    }

    @Test
    void findById(){
        Optional<Account> accountOptional = accountRepository.findById(825L);
        if (accountOptional.isEmpty()){
            return;
        }
        log.info("findById account:{}",accountOptional.get());
    }

    @Test
    void findAll(){
        List<Account> all = accountRepository.findAll();
        for (Account account : all) {
            log.info("findAll account:{}",account);
        }
    }

    private static Account buildAccount() {
        Account account = new Account();
        account.setName("a-2");
        account.setIdentities(List.of(
                buildIdentity("i-1"),
                buildIdentity("i-2")
        ));
        return account;
    }

    private static Identity buildIdentity(String name) {
        Identity identity = new Identity();
        identity.setName(name);
        identity.setRoles(List.of(
                buildRole("r-1"),
                buildRole("r-2")
        ));
        return identity;
    }

    private static Role buildRole(String name) {
        Role role = new Role();
        role.setName(name);
        role.setResources(List.of(
                buildResources("re-1"),
                buildResources("re-2")
        ));
        return role;
    }

    private static Resource buildResources(String name) {
        Resource resource = new Resource();
        resource.setName(name);
        return resource;
    }
}