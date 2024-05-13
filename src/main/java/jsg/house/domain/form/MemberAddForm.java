package jsg.house.domain.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberAddForm {
    @NotEmpty
    private String userName;

    @NotEmpty
    private String pwd;

    @NotEmpty
    private String name;

    private String address;

    private String detailAddress;

    private String email;

    private String firstPhone;
    private String middlePhone;
    private String lastPhone;

    public String finalAddress() {
        return address + " " + detailAddress;
    }

    public String finalPhone() {
        return firstPhone + "-" + middlePhone + "-" + lastPhone;
    }
}
