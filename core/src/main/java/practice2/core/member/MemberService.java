package practice2.core.member;

public interface MemberService {

    void join(Member member);

    Member findMember(long memberId);
}
