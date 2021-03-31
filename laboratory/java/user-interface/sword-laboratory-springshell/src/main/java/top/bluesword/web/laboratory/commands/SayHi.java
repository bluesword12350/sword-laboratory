package top.bluesword.web.laboratory.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * @author 李林峰
 */
@ShellComponent
public class SayHi {

    @ShellMethod(key = "你好,Shell",value = "说：‘你好，${name}’")
    public String sayHi(String name) {
        return String.format("你好，%s", name);
    }

}