package Ristorante.projectworkristorante.controller;

import Ristorante.projectworkristorante.model.Piatto;
import Ristorante.projectworkristorante.service.PiattoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/adminpiatti")
public class AdminPiattiController {

    @Autowired
    private PiattoService piattoService;

    private Piatto piatto;
    private Map<String, String> errori;

    @GetMapping
    public String getPage(HttpSession session,
                          Model model,
                          @RequestParam(name = "id", required = false) Integer id) {

        if(session.getAttribute("admin") == null)
            return  "redirect:/loginadmin";
        List<Piatto> piatti = piattoService.getPiatti();
        if(errori == null)
            piatto = id == null ? new Piatto() : piattoService.getPiattoById(id);

        model.addAttribute("piatti", piatti);
        model.addAttribute("piatto", piatto);
        model.addAttribute("errori", errori);

        return "adminpiatti";
    }

    @PostMapping
    public String formManager(
            @RequestParam("nome") String nome,
            @RequestParam("prezzo") String prezzo,
            @RequestParam("descrizione") String descrizione,
            @RequestParam("categoria") String categoria,
            @RequestParam(name = "copertina", required = false) MultipartFile copertina) {

        Object risultatoValidazione = piattoService.validaPiatto(piatto, nome, prezzo, descrizione, categoria);
        // se abbiamo errori di validazione
        if(risultatoValidazione != null) {
            piatto = (Piatto) ((Object[])risultatoValidazione)[0];
            errori = (Map<String, String>) ((Object[])risultatoValidazione)[1];

            return "redirect:/adminpiatti";
        }
        piattoService.registraPiatto(piatto, nome, prezzo, descrizione, categoria, copertina);
        piatto = null;
        errori = null;

        return "redirect:/adminpiatti";
    }

    @GetMapping("/elimina")
    public String eliminaPiatto(@RequestParam("id") int id) {

        piattoService.cancellaPiatto(id);

        return "redirect:/adminpiatti";
    }
}
