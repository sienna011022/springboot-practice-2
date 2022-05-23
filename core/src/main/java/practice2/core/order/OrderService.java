package practice2.core.order;

public interface OrderService {
    //클라이언트가 넘기는 값
    Order createOrder(Long memberId,String itemName,int itemPrice);


}
