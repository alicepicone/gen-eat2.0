package Ristorante.projectworkristorante.service;

import Ristorante.projectworkristorante.dao.UtenteDao;
import Ristorante.projectworkristorante.model.Utente;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteServiceImpl implements UtenteService{

    @Autowired
    private UtenteDao utenteDao;

    @Override
    public boolean controlloLogin(String username, String password, HttpSession session) {

        Utente utente = utenteDao.findByUsernameAndPassword(username, password);

        if(utente == null) {
            return false;
        }
        if(utente.isAdmin()) {
            session.setAttribute("admin", utente);
            return true;
        }
        session.setAttribute("utente", utente);
        return true;
    }

    @Override
    public void salvaDatiUtente(Utente utente) {
        utenteDao.save(utente);
    }

    @Override
    public boolean controlloUsername(String username) {

        if(utenteDao.findByUsername(username) == null) {
            return true;
        }
        return false;
    }

    @Override
    public List<Utente> getUtenti() {

        List<Utente> utenti = (List<Utente>) utenteDao.findAll();

        return utenti;
    }
}
