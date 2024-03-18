package Ristorante.projectworkristorante.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Ordine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "data_ora_ordine")
    private LocalDateTime dataOraOrdine;
    @Column (name = "ora_ritiro")
    private LocalTime oraRitiro;
    @Column
    private double importo;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_utente", referencedColumnName = "id")
    private Utente utente;
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable
            (
                    name = "ordine_piatto",
                    joinColumns = @JoinColumn(name = "id_ordine", referencedColumnName = "id"),
                    inverseJoinColumns = @JoinColumn(name = "id_piatto", referencedColumnName = "id")
            )
    private List<Piatto> piatti = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDataOraOrdine() {
        return dataOraOrdine;
    }

    public void setDataOraOrdine(LocalDateTime dataOraOrdine) {
        this.dataOraOrdine = dataOraOrdine;
    }

    public LocalTime getOraRitiro() {
        return oraRitiro;
    }

    public void setOraRitiro(LocalTime oraRitiro) {
        this.oraRitiro = oraRitiro;
    }

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public List<Piatto> getPiatti() {
        return piatti;
    }

    public void setPiatti(List<Piatto> piatti) {
        this.piatti = piatti;
    }
}
