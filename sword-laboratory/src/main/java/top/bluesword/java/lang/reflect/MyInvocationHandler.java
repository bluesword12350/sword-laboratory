package top.bluesword.java.lang.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 李林峰
 */
public class MyInvocationHandler implements InvocationHandler {

    private final Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理：前方执行");
        Object returnValue = method.invoke(target, args);
        System.out.println("代理：后方执行");
        return returnValue;
    }
}
