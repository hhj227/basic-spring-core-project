package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

// 구현 객체 생성
// 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결)해준다
// 주입(injection): 인터페이스에 구현체를 주입해준다
// 관심사의 분리: 객체를 생성하고 연결하는 역할과, 실행하는 역할을 분리
public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(getMemberRepository());
    }

    private MemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
    }

    private DiscountPolicy getDiscountPolicy() {
        return new RateDiscountPolicy();
    }
}
