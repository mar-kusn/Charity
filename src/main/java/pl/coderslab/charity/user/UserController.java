package pl.coderslab.charity.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create-admin-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setFirstName("Admin");
        user.setLastName("Admin");
        user.setUsername("ADMIN");
        user.setEmail("admin@donation.com.pl");
        user.setPassword("admin");
        userService.saveUser(user);
        return "admin";
    }

    @GetMapping("/logged-user")
    @ResponseBody
    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        return "Hello " + entityUser.getUsername();
    }

    @GetMapping("/register")
    public String registerFormShow(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerFormPerform(@Valid User user, BindingResult bindingResult, Model m) {
        User existUserName = userService.findByUsername(user.getUsername());

        User existUserEmail = userService.findByEmail(user.getEmail());

        if (!user.getPassword().equals(user.getPassword2())) {
            bindingResult
                    .rejectValue("password2", "error.user",
                            "Password and password2 are different");
            bindingResult
                    .rejectValue("password", "error.user",
                            "Password and password2 are different");
        }
        if (existUserName != null) {
            bindingResult
                    .rejectValue("username", "error.user",
                            "There is a user registered with the user name provided");
        }
        if (existUserEmail != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            return "register";
        }

        user.setEnabled(1);
        userService.saveUser(user);
        m.addAttribute("successMessage", "User has been registered ");
        m.addAttribute("user", new User());

        return "redirect:/login";
    }
}
