package Ristorante.projectworkristorante.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    @Pattern(regexp = "[a-zA-Zàèìòù\\s']{1,50}", message = "Caratteri non ammessi")
    private String nome;
    @Column
    @Pattern(regexp = "[a-zA-Zàèìòù\\s']{1,50}", message = "Caratteri non ammessi")
    private String cognome;
    @Column
    @Pattern(regexp = "[a-zA-Z0-9._-]{1,50}", message = "Caratteri non ammessi")
    private String username;
    @Column
    //espressione regolare di pattern
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,50}", message = "Password troppo debole")
    private String password;
    @Column (name = "numero_carta")
    private String numeroCarta;
    @Column (name = "data_di_nascita")
    private LocalDate dataDiNascita;

    @OneToMany
            (
                    mappedBy = "utente",
                    cascade = CascadeType.REMOVE,
                    fetch = FetchType.EAGER,
                    orphanRemoval = true
            )
    private List<Ordine> ordini = new ArrayList<>();

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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumeroCarta() {
        return numeroCarta;
    }

    public void setNumeroCarta(String numeroCarta) {
        this.numeroCarta = numeroCarta;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public List<Ordine> getOrdini() {
        return ordini;
    }

    public void setOrdini(List<Ordine> ordini) {
        this.ordini = ordini;
    }
}
