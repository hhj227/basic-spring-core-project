package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private final static int discountPercent = 10;

    /**
     * @return 할인되는 금액
     */
    @Override
    public int discount(Member member, int price) {
        return member.grade()== Grade.VIP? price*discountPercent/100:0;
    }
}
