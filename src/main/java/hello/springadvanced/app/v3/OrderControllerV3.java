package hello.springadvanced.app.v3;

import hello.springadvanced.trace.TraceStatus;
import hello.springadvanced.trace.hellotrace.HelloTraceV2;
import hello.springadvanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {

    private final OrderServiceV3 orderService;
    private final LogTrace trace;

    @GetMapping("/v3/request")
    public String orderItem(String itemId) {

        TraceStatus status = null;
        try {
            status = trace.begin("OrderControllerV3.orderItem()");
            orderService.orderItem(itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; // 예외를 잡았다면 다시 던져줘야한다. (로깅 때문에 app 흐름을 바꾸면 안됨)
        }

    }

}
