package hello.springadvanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {

    // 템플릿 메서드 패턴 구현
    // 변하지 않는 부분들 템플릿이라는 틀을 만들어두고, 변하는 부분을 추상 메서드로 둬서 호출하여
    // 자식 클래스에서 변하는 부분을 구현하는 방식으로 구현함

    public void execute() {
        long startTime = System.currentTimeMillis();
        call();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime: {}", resultTime);
    }

    protected abstract void call();

}
