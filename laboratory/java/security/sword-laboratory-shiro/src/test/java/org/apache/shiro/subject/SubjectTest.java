package org.apache.shiro.subject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * https://www.infoq.com/articles/apache-shiro/
 */
class SubjectTest {

    @BeforeAll
    static void before() {
        SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
        simpleAccountRealm.addAccount("username", "password","administrator");
        simpleAccountRealm.addAccount("u0", "password");
        SecurityManager defaultSecurityManager = new DefaultSecurityManager(simpleAccountRealm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);
    }

    @Test
    void login() {
        AuthenticationToken token = new UsernamePasswordToken("username", "password");
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.login(token);
        System.out.println(currentUser);
    }

    @Test
    void hasRole() {
        Subject currentUser = SecurityUtils.getSubject();
        System.out.println(currentUser.hasRole("administrator"));
        AuthenticationToken token = new UsernamePasswordToken("username", "password");
        currentUser.login(token);
        System.out.println(currentUser.hasRole("administrator"));
        AuthenticationToken t1 = new UsernamePasswordToken("u0", "password");
        currentUser.login(t1);
        System.out.println(currentUser.hasRole("administrator"));
    }

    @Test
    void isPermitted() {
        Subject currentUser = SecurityUtils.getSubject();
        System.out.println(currentUser.isPermitted("user:create"));
        AuthenticationToken token = new UsernamePasswordToken("username", "password");
        currentUser.login(token);
        System.out.println(currentUser.isPermitted("user:create"));
        AuthenticationToken t1 = new UsernamePasswordToken("u0", "password");
        currentUser.login(t1);
        System.out.println(currentUser.isPermitted("user:create"));
    }
}
