package jsg.house.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberForm {
    @NotNull
    private String userName;
    @NotNull
    private String pwd;
    @NotNull
    private String name;
    @NotNull
    private String address;
    @Email
    private String email;

    private String phone;
}
