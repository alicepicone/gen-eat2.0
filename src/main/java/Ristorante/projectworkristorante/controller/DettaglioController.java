package Ristorante.projectworkristorante.controller;

import Ristorante.projectworkristorante.model.Piatto;
import Ristorante.projectworkristorante.service.PiattoService;
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
                          Model model) {

        Piatto piatto = piattoService.getPiattoById(id);
        model.addAttribute("piatto", piatto);

        return "dettaglio";
    }

}
