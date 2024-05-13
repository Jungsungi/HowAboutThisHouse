package jsg.house.controller;

import jsg.house.domain.Member;
import jsg.house.domain.MemberForm;
import jsg.house.domain.form.MemberAddForm;
import jsg.house.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/add")
    public String memberAddForm(@ModelAttribute(name = "memberAddForm") MemberAddForm form) {

        return "views/member/joinForm";
    }

    @PostMapping("/add")
    public String memberAdd(@Validated MemberAddForm form, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("memberAddForm", form);
            return "views/member/joinForm";
        }

        Member member = new Member();
        member.setUserName(form.getUserName());
        member.setName(form.getName());
        member.setPwd(form.getPwd());
        member.setAddress(form.finalAddress());
        member.setPhone(form.finalPhone());
        member.setEmail(form.getEmail());

        memberService.saveMember(member);

        return "redirect:/login";
    }

    @PostMapping("/{userName}")
    @ResponseBody
    public String userNameCheck(@PathVariable(name = "userName") String userName) {
        Member member = memberService.findMemberByUserName(userName);

        if (member == null) {
            return null;
        }

        return member.getUserName();
    }
}
