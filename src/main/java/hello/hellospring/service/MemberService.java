package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository ;
    public MemberService(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }


    /*
    * 회원가입*/
    public Long Join(Member member){
        //이름이 똑같은 회원은 저장안함
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();


   }

   public List<Member> findMembers(){
        return memberRepository.findAll();
   }

   public Optional<Member> findOne(Long memberId){
        return memberRepository.findbyId(memberId);
   }

    private void validateDuplicateMember(Member member) {
        memberRepository.findbyName(member.getName()).ifPresent(m->{
            throw new IllegalStateException("이미존재하는 회원입니다");
        });
    }


}
