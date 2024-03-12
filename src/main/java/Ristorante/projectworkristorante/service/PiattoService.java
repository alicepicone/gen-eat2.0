package Ristorante.projectworkristorante.service;

import Ristorante.projectworkristorante.model.Piatto;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PiattoService {

    List<Piatto> getPiatti();

    Piatto getPiattoById(int id);

    List<Piatto> getPiattoByCategoria(String categoria);

    boolean aggiungiAlCarrello(int id, HttpSession session);

    List<Piatto> getCarrello(HttpSession session);

    void rimuoviDalCarrello(int id, HttpSession session);

    double getTotaleCarrello(HttpSession session);

    void registraPiatto(Piatto piatto, String nome, String prezzo, String descrizione, String categoria, MultipartFile copertina);

    void cancellaPiatto(int id);

    Object validaPiatto(Piatto piatto, String nome, String prezzo, String descrizione, String categoria);
}
