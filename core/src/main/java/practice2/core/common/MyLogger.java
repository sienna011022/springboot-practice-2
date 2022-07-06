package practice2.core.common;

import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Setter
@Scope(value = "request")
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void log(String message){
        System.out.println("["+uuid+"]"+requestURL+message);
    }
    @PostConstruct
    public void init(){
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid+this);
    }
    @PreDestroy
    public void close(){
        System.out.println("exit");
    }
}
