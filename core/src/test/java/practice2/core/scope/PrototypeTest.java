package practice2.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest {

    @Test
    void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeTest.PrototypeBean.class);

        //init 전에 생성 ->
        //destroy 호출은 안됨.
        System.out.println("findPrototoype1");
        PrototypeTest.PrototypeBean singletonBean1 = ac.getBean(PrototypeTest.PrototypeBean.class);
        System.out.println("findPrototoype2");
        PrototypeTest.PrototypeBean singletonBean2 = ac.getBean(PrototypeTest.PrototypeBean.class);
        Assertions.assertThat(singletonBean1).isSameAs(singletonBean2);

        ac.close();
    }

    @Scope("prototype")
    static class PrototypeBean {
        @PostConstruct
        public void init() {
            System.out.println("Singleton init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingletonBean.distroey");
        }
        //pre
    }
}