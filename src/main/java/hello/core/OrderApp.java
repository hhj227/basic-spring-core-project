package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {
        // 클라이언트 서비스가 구현체에 의존하고 있어서 DIP 위반
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        // DIP를 위반하기 때문에 OCP를 위반하게 됨(클라이언트에서 사용하려는 구현체를 변경하려면 클라이언트 코드도 같이 변경해야 하니까)
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = "+ order.getCalculatedPrice());
    }
}
