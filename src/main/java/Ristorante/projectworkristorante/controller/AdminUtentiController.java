package Ristorante.projectworkristorante.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminutenti")
public class AdminUtentiController {

    @GetMapping
    public String getPage(HttpSession session,
                          Model model) {

        if(session.getAttribute("admin") == null)
            return  "redirect:/loginadmin";

        return "adminutenti";
    }

}
