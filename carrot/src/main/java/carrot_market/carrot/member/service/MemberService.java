package carrot_market.carrot.member.service;

import carrot_market.carrot.member.domain.Member;
import carrot_market.carrot.member.dto.MemberUpdateRequest;

import java.io.IOException;

public interface MemberService {
    Long join(Member member);

    void update(Long memberId, MemberUpdateRequest request) throws IOException;

    Member findOne(Long memberId);

    Member findMember(String email);

    void existMemberCheck(String email);

}
