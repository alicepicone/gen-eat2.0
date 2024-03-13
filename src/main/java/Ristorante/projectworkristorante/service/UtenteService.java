package Ristorante.projectworkristorante.service;

import Ristorante.projectworkristorante.model.Utente;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface UtenteService {
    boolean controlloLogin(String username, String password, HttpSession session);
    void registraUtente(Utente utente);
    boolean controlloUsername(String username);
    List<Utente> getUtenti();
}
