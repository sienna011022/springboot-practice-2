package practice2.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import practice2.core.AppConfig;
import practice2.core.member.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {


    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();

        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = "+ memberService1);
        System.out.println("memberService2 = "+ memberService2);

        assertThat(memberService1).isNotSameAs(memberService2);

    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1" + singletonService1);
        System.out.println("singletonService2" + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //1.조회 : 호출할 때 마다 같은 객체를 반환
        MemberService memberService1 = ac.getBean("memberService",MemberService.class);
        //2.조회 : 호출할 때 마다 같은 객체를 반환
        MemberService memberService2 = ac.getBean("memberService",MemberService.class);

        //참조값이 같은걸 확인
        System.out.println("memberService1 = "+ memberService1);
        System.out.println("memberService2 = "+ memberService2);

        Assertions.assertThat(memberService1).isSameAs(memberService2);

    }

    @Test
    @DisplayName("싱글톤 문제점")
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService",StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService",StatefulService.class);

        int price1 = statefulService1.order("userA",10000);
        int price2 = statefulService2.order("userB",20000);

        //threadA : 사용자A 주문 조회
        //int price = statefulService1.getPrice();
        System.out.println("price = "+ price1);

        //사용자 A는 10000원이 조회 되는게 맞지만, B로 인해 20000원 조회
        Assertions.assertThat(price1).isEqualTo(10000);
        //threadB : 사용자B 주문 조회
        Assertions.assertThat(price2).isEqualTo(20000);



    }
    @Test
    @DisplayName("Appconfig도 사실 스프링 빈에 등록된다.")
    void configurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = "+ bean.getClass());
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}
