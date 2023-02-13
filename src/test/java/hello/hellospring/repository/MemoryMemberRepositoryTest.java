package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
    @AfterEach
    public void clearStore(){
         memoryMemberRepository.clearStore();
    }

    @Test
    public void save(){

        Member member = new Member();
        member.setName("spring");
        memoryMemberRepository.save(member);
        Member result = memoryMemberRepository.findbyId(member.getId()).get();
        Assertions.assertThat(result).isEqualTo(member);

    }

    @Test
    public void findName(){
        Member member1 = new Member();
        member1.setName("spring1");
        memoryMemberRepository.save(member1);

        Member member2= new Member();
        member2.setName("spring2");
        memoryMemberRepository.save(member2);

        Member result=memoryMemberRepository.findbyName("spring1").get();
        Assertions.assertThat(result).isEqualTo(member1);


    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        memoryMemberRepository.save(member1);

        Member member2= new Member();
        member2.setName("spring2");
        memoryMemberRepository.save(member2);

        List<Member> result =memoryMemberRepository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
