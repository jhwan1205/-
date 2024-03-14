package carrot_market.carrot.member.service;

import carrot_market.carrot.exception.MemberEmailDuplicateException;
import carrot_market.carrot.exception.MemberNotFoundException;
import carrot_market.carrot.member.domain.Member;
import carrot_market.carrot.member.dto.MemberUpdateRequest;
import carrot_market.carrot.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.apache.naming.factory.SendMailFactory;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;


    @Override
    public Long join(Member member) {
        existMemberCheck(member.getEmail());

        return memberRepository.save(member).getId();
    }

    @Override
    public void update(Long memberId, MemberUpdateRequest request) throws IOException {
        Member member = findOne(memberId);
        member.updateNickName(request.getNickName());
    }

    @Override
    public Member findOne(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> {throw new MemberNotFoundException();});
    }

    @Override
    public Member findMember(String email) {
            return memberRepository.findByEmail(email).orElseThrow(()-> {throw new MemberNotFoundException();});}

    @Override
    public void existMemberCheck(String email) {
            if(memberRepository.findByEmail(email).isPresent()) throw new MemberEmailDuplicateException();
    }
}
