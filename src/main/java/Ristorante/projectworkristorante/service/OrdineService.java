package Ristorante.projectworkristorante.service;

import Ristorante.projectworkristorante.model.Ordine;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface OrdineService {
    void inviaOrdine(HttpSession session, String slot);

    List<Ordine> getOrdini();
}
