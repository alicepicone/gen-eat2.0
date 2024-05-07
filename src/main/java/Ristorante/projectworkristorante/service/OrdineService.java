package Ristorante.projectworkristorante.service;

import Ristorante.projectworkristorante.model.Ordine;
import Ristorante.projectworkristorante.model.Utente;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface OrdineService {

    void inviaOrdine(HttpSession session, String slot);

    List<Ordine> getOrdini();

    List<Ordine> getOrdiniByUtente(Utente utente);


}
