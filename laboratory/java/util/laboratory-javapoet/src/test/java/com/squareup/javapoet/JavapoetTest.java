package com.squareup.javapoet;

import org.junit.jupiter.api.Test;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;

public class JavapoetTest {

    @Test
    void test() throws IOException {
        MethodSpec main = MethodSpec.methodBuilder("main")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(void.class)
                .addParameter(String[].class, "args")
                .addStatement("$T.out.println($S)", System.class, "你好, JavaPoet!")
                .build();

        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                .addJavadoc(String.format("@author %s\n","李林峰"))
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(main)
                .build();

        JavaFile javaFile = JavaFile.builder("top.bluesword.laboratory", helloWorld)
                .build();
        javaFile.writeTo(new File("target/java"));
    }

}
