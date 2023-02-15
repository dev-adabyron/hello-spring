package hello.hellospring.service;

import hello.hellospring.domain.Member;
import  static org.assertj.core.api.Assertions.*;
//import org.junit.jupiter.api.Assertions;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService ;
    MemoryMemberRepository memberRepository ;
    @BeforeEach
    public  void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    @AfterEach
    public void clearStore(){
        memberRepository.clearStore();
    }

    @Test
    void join() {

        //given
        Member member = new Member();
        member.setName("spring");
        //when
        Long saveId  = memberService.Join(member);

        //then
        assertEquals(member.getName(),memberService.findOne(saveId).get().getName());
    }

    @Test
    void 중복회원확인(){
        //given
        Member member1 = new Member();
        Member member2 = new Member();
        member1.setName("hi");
        member2.setName("hi");

        //when
        memberService.Join(member1);


//        //then
//        try {
//            memberService.Join(member2);
//            fail();
//        }catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.Join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}