package Ristorante.projectworkristorante.dao;

import Ristorante.projectworkristorante.model.Ordine;
import org.springframework.data.repository.CrudRepository;

public interface OrdineDao extends CrudRepository<Ordine, Integer> {
}
