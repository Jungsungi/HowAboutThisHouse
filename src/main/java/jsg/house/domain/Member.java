package jsg.house.domain;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@ToString
public class Member {
    private Long MemberId;

    private String userName;
    private String pwd;
    private String name;
    private String address;
    private String email;
    private String phone;

    private String createDate;
    private String lastUpdateDate;

    private String useYn;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(getMemberId(), member.getMemberId()) && Objects.equals(getUserName(), member.getUserName()) && Objects.equals(getPwd(), member.getPwd()) && Objects.equals(getName(), member.getName()) && Objects.equals(getAddress(), member.getAddress()) && Objects.equals(getEmail(), member.getEmail()) && Objects.equals(getPhone(), member.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMemberId(), getUserName(), getPwd(), getName(), getAddress(), getEmail(), getPhone());
    }

}
