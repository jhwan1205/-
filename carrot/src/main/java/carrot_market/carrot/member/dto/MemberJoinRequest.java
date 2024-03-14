package carrot_market.carrot.member.dto;

import carrot_market.carrot.member.domain.Member;
import carrot_market.carrot.member.domain.MemberRole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class MemberJoinRequest {    //이메일, 비밀번호, 이름, 전화번호, 별명
    private String email;
    private String password;
    private String name;
    private String phone;
    private String nickname;
    @Builder
    public MemberJoinRequest(String email, String password, String name, String phone, String nickname) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.nickname = nickname;
    }
    public Member toMemberEntity(){
        return Member.builder()
                .email(email)
                .password(password)
                .nickName(nickname)
                .name(name)
                .phone(phone)
                .memberRole(MemberRole.ROLE_USER)
                .build();
    }


}
