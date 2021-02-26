package top.bluesword.laboratory;

import com.alibaba.testable.core.annotation.MockConstructor;
import com.alibaba.testable.core.annotation.MockMethod;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;

import static com.alibaba.testable.core.matcher.InvokeVerifier.verify;
import static com.alibaba.testable.core.tool.TestableTool.MOCK_CONTEXT;
import static com.alibaba.testable.core.tool.TestableTool.SOURCE_METHOD;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DemoMockTest {

    private final DemoMock demoMock = new DemoMock();

    public static class Mock {

        @MockMethod(targetClass = DemoMock.class)
        private String innerFunc(String text) {
            return "mock_" + text;
        }

        @MockMethod(targetClass = DemoMock.class)
        private String staticFunc() {
            return "_MOCK_TAIL";
        }

        @MockMethod(targetClass = String.class)
        private String trim() {
            return "trim_string";
        }

        @MockMethod(targetClass = String.class, targetMethod = "substring")
        private String sub(int i, int j) {
            return "sub_string";
        }

        @MockMethod(targetClass = String.class)
        private boolean startsWith(String s) {
            return false;
        }

        @MockMethod(targetClass = DemoMock.class)
        private String callFromDifferentMethod() {
            if ("special_case".equals(MOCK_CONTEXT.get("case"))) {
                return "mock_special";
            }
            if ("callerOne".equals(SOURCE_METHOD)) {
                return "mock_one";
            }
            return "mock_others";
        }
    }

    @Test
    void should_able_to_mock_member_method() throws Exception {
        assertEquals("{ \"res\": \"mock_hello_MOCK_TAIL\"}", demoMock.outerFunc("hello"));
        verify("innerFunc").with("hello");
        verify("staticFunc").with();
    }

    @Test
    void should_able_to_mock_common_method() {
        assertEquals("trim_string__sub_string", demoMock.commonFunc());
        verify("trim").withTimes(1);
        verify("sub").withTimes(1);
    }

    @Test
    void should_able_to_get_source_method_name() throws Exception {
        // synchronous
        assertEquals("mock_one_mock_others", demoMock.callerOne() + "_" + demoMock.callerTwo());
        // asynchronous
        assertEquals("mock_one_mock_others",
                Executors.newSingleThreadExecutor().submit(() -> demoMock.callerOne() + "_" + demoMock.callerTwo()).get());
        verify("callFromDifferentMethod").withTimes(4);
    }

    @Test
    void should_able_to_set_mock_context() throws Exception {
        MOCK_CONTEXT.put("case", "special_case");
        // synchronous
        assertEquals("mock_special", demoMock.callerOne());
        // asynchronous
        assertEquals("mock_special", Executors.newSingleThreadExecutor().submit(demoMock::callerOne).get());
        verify("callFromDifferentMethod").withTimes(2);
    }

}
