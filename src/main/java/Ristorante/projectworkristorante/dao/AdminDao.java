package Ristorante.projectworkristorante.dao;

import Ristorante.projectworkristorante.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminDao extends CrudRepository<Admin, Integer> {
}
