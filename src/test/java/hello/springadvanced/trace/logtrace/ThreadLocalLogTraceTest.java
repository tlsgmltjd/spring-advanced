package hello.springadvanced.trace.logtrace;

import hello.springadvanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class ThreadLocalLogTraceTest {

    private ThreadLocalLogTrace trace = new ThreadLocalLogTrace();

    @Test
    void begin_end_level2() {
        TraceStatus status = trace.begin("hello");
        TraceStatus status2 = trace.begin("hello2");
        trace.end(status2);
        trace.end(status);
    }

    @Test
    void begin_exception_level2() {
        TraceStatus status = trace.begin("hello");
        TraceStatus status2 = trace.begin("hello2");
        trace.exception(status2, new RuntimeException("test"));
        trace.end(status);
    }


}