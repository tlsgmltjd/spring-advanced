package hello.springadvanced.app.v4;

import hello.springadvanced.trace.TraceStatus;
import hello.springadvanced.trace.logtrace.LogTrace;
import hello.springadvanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

    private final OrderRepositoryV4 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId) {

        AbstractTemplate<Void> template = new AbstractTemplate(trace) {
            @Override
            protected String call() {
                orderRepository.save(itemId);
                return null;
            }
        };

        template.execute("OrderServiceV4.orderItem()");
    }

}
