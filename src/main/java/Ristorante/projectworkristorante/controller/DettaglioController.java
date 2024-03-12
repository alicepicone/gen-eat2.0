package Ristorante.projectworkristorante.controller;

import Ristorante.projectworkristorante.model.Piatto;
import Ristorante.projectworkristorante.service.PiattoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dettaglio")
public class DettaglioController {

    @Autowired
    private PiattoService piattoService;

    @GetMapping
    public String getPage(@RequestParam("id") int id,
                          Model model,
                          @RequestParam(name = "add", required = false) String result) {

        Piatto piatto = piattoService.getPiattoById(id);
        model.addAttribute("piatto", piatto);
        model.addAttribute("result", result);

        return "dettaglio";
    }

    @GetMapping("/aggiungi")
    public String add(
            @RequestParam("id") int id,
            HttpSession session) {

        if(!piattoService.aggiungiAlCarrello(id, session))
            return "redirect:/dettaglio?id=" + id + "&add=n";

        return "redirect:/dettaglio?id=" + id + "&add=y";
    }

}
