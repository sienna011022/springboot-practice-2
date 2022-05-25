package practice2.core;

import practice2.core.discount.FixDiscountPolicy;
import practice2.core.member.MemberService;
import practice2.core.member.MemberServiceImpl;
import practice2.core.member.MemoryMemberRepository;
import practice2.core.order.OrderService;
import practice2.core.order.OrderServiceImpl;

public class AppConfig {
    //이전에는 memberService안에 있는
    public MemberService memberService(){

        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(),new FixDiscountPolicy());
    }
}
