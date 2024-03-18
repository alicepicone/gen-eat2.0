package Ristorante.projectworkristorante.service;

import Ristorante.projectworkristorante.model.Ordine;
import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.Optional;

public interface OrdineService {
    void inviaOrdine(HttpSession session, String slot);

    List<Ordine> getOrdini();

    Optional<Ordine> getOrdineByUtente(int idUtente);
}
