package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    @Bean
    @Primary // 기본으로 사용할 빈으로 설정
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    @Primary // 기본으로 사용할 빈으로 설정
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    @Primary // 기본으로 사용할 빈으로 설정
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    @Primary // 기본으로 사용할 빈으로 설정
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
