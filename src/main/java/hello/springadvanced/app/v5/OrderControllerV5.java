package hello.springadvanced.app.v5;

import hello.springadvanced.trace.logtrace.LogTrace;
import hello.springadvanced.trace.template.AbstractTemplate;
import hello.springadvanced.trace.templatecallback.TraceTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceTemplate template;
    private final LogTrace trace;

    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);
        this.trace = trace;
    }

    @GetMapping("/v5/request")
    public String orderItem(String itemId) {
        return template.execute("OrderControllerV5.orderItem()", () -> {
            orderService.orderItem(itemId);
            return "ok";
        });
    }

}
