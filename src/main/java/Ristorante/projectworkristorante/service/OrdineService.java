package Ristorante.projectworkristorante.service;

import jakarta.servlet.http.HttpSession;

public interface OrdineService {
    void inviaOrdine(HttpSession session, String slot);
}
