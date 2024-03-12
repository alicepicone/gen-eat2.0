package Ristorante.projectworkristorante.service;

import Ristorante.projectworkristorante.model.Piatto;
import java.util.List;

public interface PiattoService {

    List<Piatto> getPiatti();

    Piatto getPiattoById(int id);

    List<Piatto> getPiattoByCategoria(String categoria);
}
