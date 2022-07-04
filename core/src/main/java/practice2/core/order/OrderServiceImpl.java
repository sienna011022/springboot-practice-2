package practice2.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import practice2.core.annotation.MainDiscountPolicy;
import practice2.core.discount.DiscountPolicy;
import practice2.core.member.Member;
import practice2.core.member.MemberRepository;
@Component
public class OrderServiceImpl implements  OrderService{

   //하지만 OrderService 코드를 직접 바꿔야하게 됨 - 문제점 DIP,OCP 구체적인 클래스에 의존하게 된다.
   //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
   //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
   //구체에 의존 X ,인터페이스에만 의존
   private final MemberRepository memberRepository;
   private final DiscountPolicy discountPolicy;
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        //할인은 discoutPolicy에서만 ..
        int discountPrice = discountPolicy.discount(member,itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);

    }
}
