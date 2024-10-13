package Controllers;

import Data.RegistroData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home (Model model) {
        return "home";
    }

    @GetMapping("/login")
    public String login (Model model) {
        return "login";
    }

    @GetMapping("/registro")
    public String registro (Model model) {
        model.addAttribute("registroData", new RegistroData());
        return "registro";
    }

    @GetMapping("/simulacion")
    public String simulacion (Model model) {
        return "simulacion";
    }

}
