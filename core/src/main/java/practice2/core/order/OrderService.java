package practice2.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public interface OrderService {


    //클라이언트가 넘기는 값
    Order createOrder(Long memberId,String itemName,int itemPrice);


}
