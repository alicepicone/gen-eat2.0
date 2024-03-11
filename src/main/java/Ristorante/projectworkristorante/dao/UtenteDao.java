package Ristorante.projectworkristorante.dao;

import Ristorante.projectworkristorante.model.Utente;
import org.springframework.data.repository.CrudRepository;

public interface UtenteDao extends CrudRepository<Utente, Integer> {

    Utente findByUsernameAndPassword(String username, String password);

}
