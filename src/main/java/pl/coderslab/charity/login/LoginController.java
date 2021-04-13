package pl.coderslab.charity.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    // login page warrning invalid credentials change
    @GetMapping("/login")
    public String loginFormShow() {
        return "user/login";
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
