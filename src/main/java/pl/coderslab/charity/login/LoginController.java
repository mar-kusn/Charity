package pl.coderslab.charity.login;

import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    // login page warrning invalid credentials change
    @GetMapping("/login")
    public String loginFormShow(SecurityContextHolderAwareRequestWrapper request) {
        return "user/login";
    }

    @GetMapping("/whoami")
    @ResponseBody
    public String welcome(SecurityContextHolderAwareRequestWrapper request) {
        return "ROLE_ADMIN=" + request.isUserInRole("ROLE_ADMIN") + ", ROLE_USER=" + request.isUserInRole("ROLE_USER");
    }

    @GetMapping("/logout")
    public String logoutForm() {
        return "user/logout";
    }

    @PostMapping("logout")
    public String logoutPerform() {
        return "redirect:/";
    }
}