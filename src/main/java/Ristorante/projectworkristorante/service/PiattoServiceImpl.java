package Ristorante.projectworkristorante.service;

import Ristorante.projectworkristorante.dao.PiattoDao;
import Ristorante.projectworkristorante.model.Piatto;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
}
