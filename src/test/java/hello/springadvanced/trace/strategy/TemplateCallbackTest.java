package hello.springadvanced.trace.strategy;

import hello.springadvanced.trace.strategy.code.teamplate.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

    // 템플릿 콜백 패턴 - 람다
    @Test
    void callbackV1() {
        TimeLogTemplate timeLogTemplate = new TimeLogTemplate();
        timeLogTemplate.execute(() -> log.info("1"));
        timeLogTemplate.execute(() -> log.info("2"));
    }

}
