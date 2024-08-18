package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanNames = ac.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanName);

            // ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinition = " + beanDefinition);
                Object bean = ac.getBean(beanName);
                System.out.println("name = " + beanName + ", object = " + bean);
            }
        }
    }
}
