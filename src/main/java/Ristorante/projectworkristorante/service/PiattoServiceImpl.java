package Ristorante.projectworkristorante.service;

import Ristorante.projectworkristorante.dao.PiattoDao;
import Ristorante.projectworkristorante.model.Piatto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        List<Piatto> piatti = (List<Piatto>) piattoDao.findByCategoria(categoria);

        return piatti;
    }
}
