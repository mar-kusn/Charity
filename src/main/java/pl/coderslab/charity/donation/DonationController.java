package pl.coderslab.charity.donation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.category.CategoryRepository;

import java.util.List;

@Controller
public class DonationController {

    private final CategoryRepository categoryRepository;

    public DonationController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/form")
    public String formView(Model model) {
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryRepository.findAll();
    }

}
