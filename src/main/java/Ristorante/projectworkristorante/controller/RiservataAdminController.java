package Ristorante.projectworkristorante.controller;

import Ristorante.projectworkristorante.model.Utente;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/riservataadmin")
public class RiservataAdminController {

    @GetMapping
    public String getPage(HttpSession session,
                          Model model) {

        if(session.getAttribute("admin") == null)
            return  "redirect:/loginadmin";

        Utente admin = (Utente) session.getAttribute("admin");
        model.addAttribute("user", admin);

        return "riservataadmin";
    }

    @GetMapping("/logout")
    public  String adminLogout(HttpSession session) {

        session.removeAttribute("admin");

        return "redirect:/";
    }

}
