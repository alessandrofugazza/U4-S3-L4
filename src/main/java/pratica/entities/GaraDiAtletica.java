package pratica.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.Set;

@Entity
@DiscriminatorValue("GaraDiAtletica")
public class GaraDiAtletica extends Evento {
    private Set<Persona> athletes;
    private Persona winner;
    public GaraDiAtletica(){}

    public GaraDiAtletica(String titolo, Date dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Set<Persona> athletes, Persona winner) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.athletes = athletes;
        this.winner = winner;
    }

    public Set<Persona> getAthletes() {
        return athletes;
    }

    public void setAthletes(Set<Persona> athletes) {
        this.athletes = athletes;
    }

    public Persona getWinner() {
        return winner;
    }

    public void setWinner(Persona winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "athletes=" + athletes +
                ", winner=" + winner +
                '}';
    }
}
