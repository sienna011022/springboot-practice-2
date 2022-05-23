package practice2.core.order;

import practice2.core.discount.DiscountPolicy;
import practice2.core.discount.FixDiscountPolicy;
import practice2.core.member.Member;
import practice2.core.member.MemberRepository;
import practice2.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements  OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        //할인은 discoutPolicy에서만 ..
        int discountPrice = discountPolicy.discount(member,itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);

    }
}
