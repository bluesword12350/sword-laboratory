package top.bluesword.java.lang.reflect;

/**
 * @author 李林峰
 */
public class UserServiceImpl implements IUserService{

    @Override
    public void add(String name) {
        System.out.println("原方法执行："+name);
    }

}
