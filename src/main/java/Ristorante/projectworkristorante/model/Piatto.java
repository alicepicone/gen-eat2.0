package Ristorante.projectworkristorante.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@Entity
@Table
public class Piatto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    @Pattern(regexp = "[a-zA-Zàèìòù\\s']{1,50}", message = "Caratteri non ammessi")
    private String nome;
    @Column
    private double prezzo;
    @Column
    private String categoria;
    @Column
    private String copertina;
    @Column
    private String descrizione;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCopertina() {
        return copertina;
    }

    public void setCopertina(String copertina) {
        this.copertina = copertina;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
