package hello.springadvanced.trace.template;

import hello.springadvanced.trace.template.code.AbstractTemplate;
import hello.springadvanced.trace.template.code.SubClassLogic1;
import hello.springadvanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

// template method 패턴: 변하는 부분과 변하지 않는 부분을 분리하여 모듈화 하는 패턴

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0() {
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
        템플릿 메서드 패턴 적용
     */
    @Test
    void templateMethodV1() {
        AbstractTemplate t1 = new SubClassLogic1();
        AbstractTemplate t2 = new SubClassLogic2();

        t1.execute();
        t2.execute();
    }

    // 익명 내부 클래스로 템플릿 메서드 패턴 사용하기
    @Test
    void templateMethodV2() {
        AbstractTemplate abstractTemplate1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직 1 실행");
            }
        };

        AbstractTemplate abstractTemplate2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직 2 실행");
            }
        };

        abstractTemplate1.execute();
        abstractTemplate2.execute();
    }
}
