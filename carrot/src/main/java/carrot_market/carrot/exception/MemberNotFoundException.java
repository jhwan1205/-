package carrot_market.carrot.exception;

public class MemberNotFoundException extends RuntimeException{
    public MemberNotFoundException(){super("회원을 찾지 못했습니다.");}
}
