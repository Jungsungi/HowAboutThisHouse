package jsg.house.domain.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {

    @NotEmpty(message = "아이디는 필수로 입력하셔야 합니다.")
    private String loginId;
    @NotEmpty(message = "비밀번호는 필수로 입력하셔야 합니다.")
    private String loginPwd;
}
