package practice2.core.beanfind;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import practice2.core.AppConfig;
import practice2.core.member.Member;
import practice2.core.member.MemberRepository;
import practice2.core.member.MemoryMemberRepository;

import java.lang.annotation.Annotation;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class ApplicationContextSameBeanFindText {
    AnnotationConfigApplicationContext ac = new
            AnnotationConfigApplicationContext(SameBeanConfig.class);



//    @Test
//    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면 중복 오류 발생")
//
//    //NoUniqueBean Exception터짐
//    void findBeanByTypeDuplicate() {
//       ac.getBean(MemberRepository.class);
//        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
//                ()->ac.getBean(MemberRepository.class));
//    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면 이름으로 조회")

    void findByName(){
        MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입 모두 조회하기")
    void findAllBeanType(){
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = "+key+"value = "+ beansOfType.get(key));
        }

        System.out.println("beansofType "+beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);
    }



    @Configuration
    //시험을 위해 appconfig하나 생성
    static class SameBeanConfig{
        @Bean
        public MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }

    }
    }
