package top.bluesword.web.laboratory.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class SayHi {
    @ShellMethod("say-hi")
    public String sayHi(String name) {
        return String.format("Hi %s", name);
    }
}