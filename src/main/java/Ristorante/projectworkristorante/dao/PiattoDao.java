package Ristorante.projectworkristorante.dao;

import Ristorante.projectworkristorante.model.Piatto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PiattoDao extends CrudRepository<Piatto, Integer> {
    List<Piatto> findByCategoria(String categoria);

}
