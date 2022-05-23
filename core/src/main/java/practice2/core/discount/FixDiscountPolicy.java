package practice2.core.discount;

import practice2.core.member.Grade;
import practice2.core.member.Member;

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
