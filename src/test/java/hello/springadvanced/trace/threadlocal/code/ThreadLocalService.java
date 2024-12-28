package hello.springadvanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalService {

    // ThreadLocal:
    // 멀티 스레딩 환경에서 싱글톤 빈의 필드(공유 자원)에 여러 스레드가 동시에 접근하여 값을 읽고 쓴다면 동시성 문제가 발생함
    // 여러 스레드가 동시에 접근해도 각 스레드만의 저장공간에 값을 저장, 조회할 수 있게 하여 동시성 문제를 해결해주는 객체

    // 주의점: 해당 스레드가 스레드 로컬을 사용하고 나면 .remove()로 저장된 값을 제거해주어여 한다.
    private ThreadLocal<String> nameStore = new ThreadLocal<>();

    public String logic(String name) {
        log.info("저장 name = {} -> name store = {}", name, nameStore.get());
        nameStore.set(name);
        sleep(1000);
        log.info("조회 name store = {}", nameStore.get());
        return nameStore.get();
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
