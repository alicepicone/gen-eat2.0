package Ristorante.projectworkristorante.controller;

import Ristorante.projectworkristorante.model.Piatto;
import Ristorante.projectworkristorante.service.PiattoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private PiattoService piattoService;

    @GetMapping
    public String getPage(
            Model model,
            @RequestParam(name = "categoria", required = false) String categoria) {

        List<Piatto> piatti = categoria == null ? piattoService.getPiatti() : piattoService.getPiattoByCategoria(categoria);
        model.addAttribute("piatti", piatti);
        if (categoria != null) {
            model.addAttribute("cat", categoria);
        }

        return "index";
    }

}
