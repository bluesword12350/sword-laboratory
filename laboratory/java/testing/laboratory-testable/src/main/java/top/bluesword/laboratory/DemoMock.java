package top.bluesword.laboratory;

import java.nio.file.Files;
import java.nio.file.Paths;

public class DemoMock {

    /**
     * method with member method invoke
     */
    public String outerFunc(String s) throws Exception {
        return "{ \"res\": \"" + innerFunc(s) + staticFunc() + "\"}";
    }

    /**
     * method with common method invoke
     */
    public String commonFunc() {
        return "anything".trim() + "__" + "anything".substring(1, 3);
    }

    /**
     * two methods invoke same private method
     */
    public String callerOne() {
        return callFromDifferentMethod();
    }

    public String callerTwo() {
        return callFromDifferentMethod();
    }

    private static String staticFunc() {
        return "_STATIC_TAIL";
    }

    private String innerFunc(String s) throws Exception {
        return String.join("", Files.readAllLines(Paths.get("/a-not-exist-file")));
    }

    private String callFromDifferentMethod() {
        return "realOne";
    }

}
