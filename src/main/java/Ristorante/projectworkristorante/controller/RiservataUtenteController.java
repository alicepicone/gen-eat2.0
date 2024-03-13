package Ristorante.projectworkristorante.controller;

import Ristorante.projectworkristorante.model.Piatto;
import Ristorante.projectworkristorante.model.Utente;
import Ristorante.projectworkristorante.service.OrdineService;
import Ristorante.projectworkristorante.service.PiattoService;
import Ristorante.projectworkristorante.service.UtenteService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/riservatautente")
public class RiservataUtenteController {

    @Autowired
    private OrdineService ordineService;

    @Autowired
    private PiattoService piattoService;

    @Autowired
    private UtenteService utenteService;

    @GetMapping
    public String getPage(HttpSession session,
                          Model model,
                          @RequestParam(name = "send", required = false) String send) {

        if(session.getAttribute("utente") == null)
            return  "redirect:/loginutente";

        Utente utente = (Utente) session.getAttribute("utente");
        model.addAttribute("utente", utente);
        model.addAttribute("carrello", piattoService.getCarrello(session));
        model.addAttribute("totale", piattoService.getTotaleCarrello(session));
        model.addAttribute("send", send);

        return "riservatautente";

    }

    @GetMapping("/logout")
    public  String userLogout(HttpSession session) {

        session.removeAttribute("utente");

        return "redirect:/";
    }

    @GetMapping("/rimuovi")
    public String remove(@RequestParam("id") int id,
                         HttpSession session) {

        piattoService.rimuoviDalCarrello(id, session);
        return "redirect:/riservatautente";
    }

    @PostMapping
    public String formManager(
            @Valid @ModelAttribute("user") Utente utente,
            BindingResult result,
            HttpSession session) {

        if(result.hasErrors())
            return "riservatautente";

        utenteService.registraUtente(utente);
        session.setAttribute("utente", utente);

        return "redirect:/riservatautente";
    }

    @PostMapping("/invia")
    public String inviaOrdine(
            @RequestParam("slot") String slot,
            HttpSession session) {
        ordineService.inviaOrdine(session, slot);

        return "redirect:/riservatautente?send";
    }


}
