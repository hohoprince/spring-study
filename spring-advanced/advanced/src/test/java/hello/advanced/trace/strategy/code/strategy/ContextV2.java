package hello.advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV2 {

    public void execute(Strategy strategy) {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        strategy.call(); // 위임

        // 비즈니스 로직 종료
        long resultTime = System.currentTimeMillis() - startTime;
        log.info("resultTime={}", resultTime);
    }
}
