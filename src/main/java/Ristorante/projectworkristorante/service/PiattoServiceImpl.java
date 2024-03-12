package Ristorante.projectworkristorante.service;

import Ristorante.projectworkristorante.dao.PiattoDao;
import Ristorante.projectworkristorante.model.Piatto;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.regex.Pattern;

@Service
public class PiattoServiceImpl implements PiattoService {

    @Autowired
    private PiattoDao piattoDao;

    @Override
    public List<Piatto> getPiatti() {

        List<Piatto> piatti = (List<Piatto>) piattoDao.findAll();

        return piatti;
    }

    @Override
    public Piatto getPiattoById(int id) {

        Optional<Piatto> piattoOptional = piattoDao.findById(id);
        if(piattoOptional.isPresent())
            return piattoOptional.get();

        return null;
    }

    @Override
    public List<Piatto> getPiattoByCategoria(String categoria) {
        return piattoDao.findByCategoria(categoria);
    }

    @Override
    public boolean aggiungiAlCarrello(int id, HttpSession session) {

        Piatto piatto = getPiattoById(id);
        List<Piatto> carrello;
        if(session.getAttribute("carrello") != null) {
            carrello = (List<Piatto>) session.getAttribute("carrello");
            for(Piatto p : carrello)
                if(p.getId() == id)
                    return false;

            carrello.add(piatto);
            session.setAttribute("carrello", carrello);
            return true;
        } else {
            carrello = new ArrayList<>();
            carrello.add(piatto);
            session.setAttribute("carrello", carrello);
            return true;
        }
    }

    @Override
    public List<Piatto> getCarrello(HttpSession session) {

        if(session.getAttribute("carrello") != null)
            return (List<Piatto>) session.getAttribute("carrello");

        return null;
    }

    @Override
    public void rimuoviDalCarrello(int id, HttpSession session) {
        List<Piatto> carrello = (List<Piatto>) session.getAttribute("carrello");
        for(Piatto p : carrello)
            if(p.getId() == id) {
                carrello.remove(p);
                break;
            }
        if(carrello.size() > 0) //sovrascriviamo
            session.setAttribute("carrello", carrello);
        else // rimuoviamo completamente
            session.removeAttribute("carrello");
    }

    @Override
    public double getTotaleCarrello(HttpSession session) {

        List<Piatto> carrello = (List<Piatto>) session.getAttribute("carrello");

        if(carrello != null)
            return carrello
                    .stream()
                    .mapToDouble(Piatto::getPrezzo)
                    .reduce(0.0, (l1, l2) -> l1 + l2);

        return 0;
    }

    @Override
    public void registraPiatto(Piatto piatto, String nome, String prezzo, String descrizione, String categoria, MultipartFile copertina) {
        piatto.setNome(nome);
        piatto.setPrezzo(Double.parseDouble(prezzo));
        piatto.setDescrizione(descrizione);
        piatto.setCategoria(categoria);

        if(copertina != null && !copertina.isEmpty()) {
            try {
                String formato = copertina.getContentType();
                String copertinaCodificata = "data:" + formato + ";base64," +
                        Base64.getEncoder().encodeToString(copertina.getBytes());
                piatto.setCopertina(copertinaCodificata);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        piattoDao.save(piatto);
    }

    @Override
    public void cancellaPiatto(int id) {
        piattoDao.deleteById(id);
    }

    @Override
    public Object validaPiatto(Piatto piatto, String nome, String prezzo, String descrizione, String categoria) {

        piatto.setNome(nome);
        //dichiariamo una mappa di eventuali errori
        Map<String, String> errori = new HashMap<>();
        //inseriamo un errore nella mappa se il titolo non passa il controllo
        if(!Pattern.matches("[a-zA-Z0-9\\sàèìòù,.-]{1,50}", nome)) {
            errori.put("nome", "Caratteri non ammessi");
        }
        //proviamo a settare il prezzo o inseriamo un errore nella mappa
        try {
            piatto.setPrezzo(Double.parseDouble(prezzo));
        } catch (Exception e) {
            errori.put("prezzo", "Il prezzo indicato non è corretto");
        }
        //se abbiamo errori nella mappa ritorniamo l'oggetto libro e gli errori
        if(errori.size() > 0)
            return new Object[]{piatto, errori};
        else //se non abbiamo errori
            return null;

    }


}
