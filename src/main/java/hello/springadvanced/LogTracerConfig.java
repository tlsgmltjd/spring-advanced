package hello.springadvanced;

import hello.springadvanced.trace.logtrace.FieldLogTrace;
import hello.springadvanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTracerConfig {

    @Bean
    public LogTrace logTrace() {
        return new FieldLogTrace();
    }

}
