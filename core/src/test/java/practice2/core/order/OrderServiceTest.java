package practice2.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import practice2.core.member.Grade;
import practice2.core.member.Member;
import practice2.core.member.MemberService;
import practice2.core.member.MemberServiceImpl;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();


    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
