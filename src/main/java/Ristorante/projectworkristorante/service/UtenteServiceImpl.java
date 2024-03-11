package Ristorante.projectworkristorante.service;

import Ristorante.projectworkristorante.dao.UtenteDao;
import Ristorante.projectworkristorante.model.Utente;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteServiceImpl implements UtenteService{

    @Autowired
    private UtenteDao utenteDao;

    @Override
    public boolean controlloLogin(String username, String password, HttpSession session) {

        Utente utente = utenteDao.findByUsernameAndPassword(username, password);

        if(utente != null) {
            session.setAttribute("utente", utente);
            return true;
        }
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
