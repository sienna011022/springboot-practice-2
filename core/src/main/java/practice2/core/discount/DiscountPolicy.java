package practice2.core.discount;

import practice2.core.member.Member;

public interface DiscountPolicy {
    //return 할인 대상 금액
    int discount(Member member, int price);
}
