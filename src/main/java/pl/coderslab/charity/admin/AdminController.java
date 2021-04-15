package pl.coderslab.charity.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.donation.DonationRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final DonationRepository donationRepository;

    public AdminController(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @GetMapping("")
    public String adminPanel(Model model) {
        Integer bagsSum = donationRepository.returnedBagsSum();
        if (bagsSum == null) {
            bagsSum = 0;
        }
        model.addAttribute("returnedBagsSum", bagsSum);

        model.addAttribute("donationsSum", donationRepository.count());
        return "admin/index";
    }
}
