package practice2.core.singleton;

public class StatefulService {

//    private int price;
//    public void order(String name,int price){
//        System.out.println("name = "+name+"price"+ price);
//        this.price = price; //여기가 문제
//
//    }
    public int order(String name,int price) {
        System.out.println("name = " + name + "price" + price);
    //    this.price = price;
        return price;

    }

}
