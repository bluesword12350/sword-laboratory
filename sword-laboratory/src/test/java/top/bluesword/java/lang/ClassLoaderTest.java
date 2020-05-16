package top.bluesword.java.lang;

import org.junit.jupiter.api.Test;

class ClassLoaderTest {

    @Test
    void getResource(){
        ClassLoader classLoader = getClassLoader();
        System.out.println(classLoader.getResource("java/JavaFile.java"));
    }

    private ClassLoader getClassLoader() {
        return this.getClass().getClassLoader();
    }
}
