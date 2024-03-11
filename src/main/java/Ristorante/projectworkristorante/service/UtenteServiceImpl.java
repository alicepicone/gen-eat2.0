package Ristorante.projectworkristorante.service;

import Ristorante.projectworkristorante.model.Utente;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class UtenteServiceImpl implements UtenteService{

    @Override
    public boolean controlloLogin(String username, String password, HttpSession session) {
        return false;
    }

    @Override
    public void registraUtente(Utente utente) {

    }

    @Override
    public boolean controlloUsername(String username) {
        return false;
    }
}
