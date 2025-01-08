package hello.springadvanced.trace.strategy.code.strategy;

/*
    필드에 전략을 보관하는 방식
 */

import lombok.extern.slf4j.Slf4j;

// context: 문맥, 전략 패턴에서 문맥은 크게 변하지 않지만 그 안의 전략이 조금씩 변하게 된다.
// -> Context는 Strategy 인터페이스에 의존하고 있기 때문에 원하는 구현체를 주입해서 실행할 수 있다.
// -> 스프링 DI가 전략 패턴임

// 1. Context에 원하는 Strategy 주입. 2. Context를 실행. 3. Context는 로직 실행 중에 주입된 Strategy를 실행
// 템플릿 메서드 패턴과 달리 Context의 코드가 변경되어도 Context는 Strategy 인터페이스를 의존하고 있기 때문에 구현체는 영향을 받지 않음
@Slf4j
public class ContextV1 {

    private Strategy strategy;

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        long startTime = System.currentTimeMillis();
        log.info("=== log start ===");

        // biz start
        strategy.call();
        // biz end

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime: {}", resultTime);
        log.info("=== log end ===");
    }

}
