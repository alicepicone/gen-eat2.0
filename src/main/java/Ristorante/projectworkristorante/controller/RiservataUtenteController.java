package Ristorante.projectworkristorante.controller;

import Ristorante.projectworkristorante.model.Utente;
import Ristorante.projectworkristorante.service.UtenteService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/riservatautente")
public class RiservataUtenteController {

    @Autowired
    private UtenteService utenteService;

    @GetMapping
    public String getPage(HttpSession session,
                          Model model) {

        if(session.getAttribute("utente") == null)
            return  "redirect:/loginutente";

        Utente utente = (Utente) session.getAttribute("utente");
        model.addAttribute("username", utente);

        return "riservatautente";

    }

    @GetMapping("/logout")
    public  String userLogout(HttpSession session) {

        session.removeAttribute("utente");

        return "redirect:/";
    }

}
