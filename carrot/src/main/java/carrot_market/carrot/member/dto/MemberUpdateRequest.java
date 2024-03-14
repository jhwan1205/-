package carrot_market.carrot.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class MemberUpdateRequest {
    private MultipartFile profile;
    private String nickName;

    @Builder
    public MemberUpdateRequest(MultipartFile profile, String nickName) {
        this.profile = profile;
        this.nickName = nickName;
    }
}
