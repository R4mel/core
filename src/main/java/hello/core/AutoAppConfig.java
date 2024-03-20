package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // AppConfig 제외 코드
)
public class AutoAppConfig {
    @Bean(name = "memorymemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
