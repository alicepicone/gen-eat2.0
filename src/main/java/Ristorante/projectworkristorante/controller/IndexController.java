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
    public String getPage(Model model) {

        List<Piatto> piatti = piattoService.getPiatti();
        model.addAttribute("piatti", piatti);


        return "index";
    }

    @GetMapping("/categoria")
    public String filtroCategoria(@RequestParam(name = "categoria") String categoria, Model model) {

        List<Piatto> piattiPerCategoria = piattoService.getPiattoByCategoria(categoria);
        if (piattiPerCategoria == null || piattiPerCategoria.isEmpty()){
            return "redirect:/";
        }
        model.addAttribute("piattiPerCategoria", piattiPerCategoria);
        return "index";
    }



}
