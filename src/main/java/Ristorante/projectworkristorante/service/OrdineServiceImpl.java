package Ristorante.projectworkristorante.service;

import Ristorante.projectworkristorante.dao.OrdineDao;
import Ristorante.projectworkristorante.model.Ordine;
import Ristorante.projectworkristorante.model.Piatto;
import Ristorante.projectworkristorante.model.Utente;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class OrdineServiceImpl implements OrdineService{

    @Autowired
    private OrdineDao ordineDao;
    @Autowired
    private PiattoService piattoService;

    @Override
    public void inviaOrdine(HttpSession session, String slot) {

        List<Piatto> carrello = (List<Piatto>) session.getAttribute("carrello");
        Utente utente = (Utente) session.getAttribute("utente");

        if(carrello != null && utente != null) {
            Ordine ordine = new Ordine();
            ordine.setDataOraOrdine(LocalDateTime.now());
            ordine.setUtente(utente);
            ordine.setPiatti(carrello);
            ordine.setImporto(piattoService.getTotaleCarrello(session));
            ordine.setDataOraRitiro(LocalTime.parse(slot));
            ordineDao.save(ordine);
            utente.getOrdini().add(ordine);
            session.setAttribute("utente", utente);
            session.removeAttribute("carrello");
        }
    }
}
