package hello.springadvanced.trace.strategy;

import hello.springadvanced.trace.strategy.code.strategy.ContextV1;
import hello.springadvanced.trace.strategy.code.strategy.Strategy;
import hello.springadvanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.springadvanced.trace.strategy.code.strategy.StrategyLogic2;
import hello.springadvanced.trace.template.code.AbstractTemplate;
import hello.springadvanced.trace.template.code.SubClassLogic1;
import hello.springadvanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    @Test
    void strategyV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        // biz start
        log.info("비즈니스 로직 1 실행");
        // biz end
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime: {}", resultTime);
    }


    private void logic2() {
        long startTime = System.currentTimeMillis();
        // biz start
        log.info("비즈니스 로직 2 실행");
        // biz end
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime: {}", resultTime);
    }

    /*
        전략 패턴 사용
     */
    @Test
    void strategyV1() {
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 context1 = new ContextV1(strategyLogic1);


        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV1 context2 = new ContextV1(strategyLogic2);

        context1.execute();
        context2.execute();
    }

    @Test
    void strategyV2() {
        Strategy strategy1 = new Strategy() {
            @Override
            public void call() {
                log.info("biz 1");
            }
        };
        System.out.println("============== " + strategy1.getClass());
        ContextV1 context1 = new ContextV1(strategy1);


        Strategy strategy2 = new Strategy() {
            @Override
            public void call() {
                log.info("biz 2");
            }
        };
        System.out.println("============== " + strategy2.getClass());
        ContextV1 context2 = new ContextV1(strategy2);

        context1.execute();
        context2.execute();
    }

    @Test
    void strategyV3() {
        ContextV1 context1 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("biz 1");
            }
        });

        ContextV1 context2 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("biz 2");
            }
        });

        context1.execute();
        context2.execute();
    }

    // 자바 8부터 지원하는 람다로 익명 내부 클래스를 간편하게 구현 가능
    // 인터페이스에 메서드가 한개(functional interface, Strategy는 functional interface) 여야함
    @Test
    void strategyV4() {
        ContextV1 context1 = new ContextV1(() -> log.info("biz 1"));
        ContextV1 context2 = new ContextV1(() -> log.info("biz 2"));

        context1.execute();
        context2.execute();
    }

    // 선 조립 후 실행 방식이다.
}
