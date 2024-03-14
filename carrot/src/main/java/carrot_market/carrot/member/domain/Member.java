package carrot_market.carrot.member.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member")
@Getter
@NoArgsConstructor
public class Member {
    @Id
    private Long id;

    private String email;

    private String password;

    private String name;

    private String nickName;

    private String phone;

    private int mannerTemp = 0;

    private MemberRole memberRole;

    private String profile;

    @Builder
    public Member(Long id, String email, String password, String name, String nickName, String phone, int mannerTemp, MemberRole memberRole, String profile) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.phone = phone;
        this.mannerTemp = mannerTemp;
        this.memberRole = memberRole;
        this.profile = profile;
    }

    /* 비즈니스 로직 */

    // 닉네임 업데이트
    public void updateNickName(String nickName) {
        this.nickName = nickName;
    }

    // 프로필 업데이트
    public void updateProfile(String profile) {
        this.profile = profile;
    }
}
