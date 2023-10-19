package pratica.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Entity
@DiscriminatorValue("GaraDiAtletica")
public class Concerto extends Evento{
    @Enumerated(EnumType.STRING)
    private MusicGenre genre;
    private boolean inStraming;

    public Concerto() {
    }

    public Concerto(String titolo, Date dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, MusicGenre genre, boolean inStraming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.genre = genre;
        this.inStraming = inStraming;
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }

    public boolean isInStraming() {
        return inStraming;
    }

    public void setInStraming(boolean inStraming) {
        this.inStraming = inStraming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genre=" + genre +
                ", inStraming=" + inStraming +
                '}';
    }
}
