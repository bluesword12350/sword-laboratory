package top.bluesword.java.lang.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

import static org.junit.jupiter.api.Assertions.*;

class MyInvocationHandlerTest {

    @Test
    void invoke() {
        IUserService target = new UserServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(target);
        IUserService proxyObject = (IUserService) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);
        proxyObject.add("李林峰");
    }

}