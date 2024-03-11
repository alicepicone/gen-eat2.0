package Ristorante.projectworkristorante.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@Entity
@Table
public class Amministratore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    @Pattern(regexp = "[a-zA-Z0-9._-]{1,50}", message = "Caratteri non ammessi")
    private String username;
    @Column
    //espressione regolare di pattern
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,50}", message = "Password troppo debole")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
