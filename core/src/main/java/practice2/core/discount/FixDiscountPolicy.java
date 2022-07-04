package practice2.core.discount;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import practice2.core.member.Grade;
import practice2.core.member.Member;

@Component

public class FixDiscountPolicy implements DiscountPolicy{
    //1000원 항인

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount ;
        }else {
            return 0;
        }
    }
}
