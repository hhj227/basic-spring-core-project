package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 구현체를 의존하지 않고, 인터페이스에만 의존한다.
    // 의존관계에 대한 고민은 외부(AppConfig)에만 맡기고, 실행에만 집중하면 된다.
    // 클라이언트인 MemberServiceImpl 입장에서 보면, 의존관계를 마치 외부에서 주입해주는 것 같다고 해서
    // DI(Dependency Injection) 또는 의존관계 주입이라고 부른다.
    private final MemberRepository memberRepository;

    // 생성자 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
