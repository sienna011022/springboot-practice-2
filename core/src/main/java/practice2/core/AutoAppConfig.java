package practice2.core;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// Bean을 다 등록해줌
@ComponentScan(
        //뺼거 등록해줌
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION ,classes = Configuration.class))
public class AutoAppConfig {

}
