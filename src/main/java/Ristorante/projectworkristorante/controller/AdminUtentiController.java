package Ristorante.projectworkristorante.controller;

import Ristorante.projectworkristorante.model.Ordine;
import Ristorante.projectworkristorante.model.Utente;
import Ristorante.projectworkristorante.service.OrdineService;
import Ristorante.projectworkristorante.service.UtenteService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/adminutenti")
public class AdminUtentiController {

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private OrdineService ordineService;

    @GetMapping
    public String getPage(HttpSession session,
                          Model model) {
        if(session.getAttribute("admin") == null) {
            return  "redirect:/loginadmin";
        }

        List<Utente> utenti = utenteService.getUtenti();
        model.addAttribute("utenti", utenti);
        List<Ordine> ordini = ordineService.getOrdini();
        model.addAttribute("ordini", ordini);
        return "adminutenti";
    }

}
