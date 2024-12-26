package hello.springadvanced.app.v2;

import hello.springadvanced.trace.TraceStatus;
import hello.springadvanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {

    private final OrderServiceV2 orderService;
    private final HelloTraceV2 trace;

    @GetMapping("/v2/request")
    public String orderItem(String itemId) {

        TraceStatus status = null;
        try {
            status = trace.begin("OrderControllerV2.orderItem()");
            orderService.orderItem(status.getTraceId(), itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; // 예외를 잡았다면 다시 던져줘야한다. (로깅 때문에 app 흐름을 바꾸면 안됨)
        }

    }

}
