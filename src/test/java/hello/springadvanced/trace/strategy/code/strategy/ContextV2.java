package hello.springadvanced.trace.strategy.code.strategy;

/*
    전략을 파라미터로 전달 받음
 */

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV2 {

    public void execute(Strategy strategy) {
        long startTime = System.currentTimeMillis();

        // biz start
        strategy.call();
        // biz end

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime: {}", resultTime);
    }

}
