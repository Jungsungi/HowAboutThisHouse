package jsg.house.controller;

import jakarta.servlet.http.HttpServletRequest;
import jsg.house.domain.Member;
import jsg.house.domain.form.LoginForm;
import jsg.house.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute(name = "loginForm") LoginForm loginForm) {
        log.info("loginForm Method Start");

        log.info("loginForm Method End");

        return "views/login/loginForm";
    }

    @PostMapping("/login")
    public String login(@Validated LoginForm loginForm, BindingResult bindingResult, HttpServletRequest request) {
        log.info("login Method Start");
        if (bindingResult.hasErrors()) {
            log.info("validation error");
            return "views/login/loginForm";
        }

        //회원 정보 조회
        String result = memberService.login(loginForm.getLoginId(), loginForm.getLoginPwd(), request, bindingResult);

        log.info("login Method End");

        return result;
    }
}
