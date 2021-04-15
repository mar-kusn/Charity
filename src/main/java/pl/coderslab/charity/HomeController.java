package pl.coderslab.charity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.donation.DonationRepository;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionRepository;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {

    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    public HomeController(InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    @RequestMapping("/")
    public String homeAction(Model model){

        Page<Institution> institutionsPage = institutionRepository.findAll(PageRequest.of(0, 4));
        List<Institution> institutions = new ArrayList<>();
        if(institutionsPage != null && institutionsPage.hasContent()) {
            institutions = institutionsPage.getContent();
        }
        model.addAttribute("institutions", institutions);

        Integer bagsSum = donationRepository.returnedBagsSum();
        if (bagsSum == null) {
            bagsSum = 0;
        }
        model.addAttribute("returnedBagsSum", bagsSum);

        model.addAttribute("donationsSum", donationRepository.count());

        return "index";
    }

    @GetMapping("/403")
    public String accessDenied(Model model) {
        return "admin/403";
    }

}
