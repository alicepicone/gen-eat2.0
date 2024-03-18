package Ristorante.projectworkristorante.dao;

import Ristorante.projectworkristorante.model.Ordine;
import Ristorante.projectworkristorante.model.Utente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdineDao extends CrudRepository<Ordine, Integer> {

    List<Ordine> findOrdiniByUtente(Utente utente);
}
