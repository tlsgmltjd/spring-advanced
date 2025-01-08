package hello.springadvanced.app.v4;

import hello.springadvanced.trace.TraceStatus;
import hello.springadvanced.trace.logtrace.LogTrace;
import hello.springadvanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace trace;

    public void save(String itemId) {

        AbstractTemplate<Void> template = new AbstractTemplate(trace) {
            @Override
            protected String call() {
                if (itemId.equals("ex")) {
                    throw new IllegalArgumentException("예외 발생!");
                }
                sleep(1000);
                return null;
            }
        };

        template.execute(itemId);
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
