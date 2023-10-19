package pratica.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento event) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(event);
        transaction.commit();
        System.out.println("New event saved successfully.");
    }

    public Evento getById(UUID id) {
        return em.find(Evento.class, id);
    }

    public void delete(UUID id) {

        Evento found = em.find(Evento.class, id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Event deleted successfully.");
        } else {
            System.err.println("Event for id " + id + " wasn't found.");
        }

    }

    public void refresh(Evento event) {
            em.refresh(event);
            System.out.println("Event \"" + event.getTitolo() + "\"has been refreshed.");
    }

    public List<Concerto> getConcertiInStreaming(boolean inStraming) {
        TypedQuery<Concerto> getConcertiInStreamingQuery = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :instraming", Concerto.class);
        getConcertiInStreamingQuery.setParameter("instreaming", inStraming);
        return getConcertiInStreamingQuery.getResultList();
    }
    public List<Concerto> getConcertiPerGenere(MusicGenre genre) {
        TypedQuery<Concerto> getConcertiPerGenereQuery = em.createQuery("SELECT c FROM Concerto c WHERE c.genre = :genre", Concerto.class);
        getConcertiPerGenereQuery.setParameter("genre", genre);
        return getConcertiPerGenereQuery.getResultList();
    }

    public Integer getPartiteVinteInCasa() {
        TypedQuery<Integer> getPartiteVinteInCasa = em.createNamedQuery("getPartiteVinteInCasa", Integer.class);
        return getPartiteVinteInCasa.getSingleResult();
    }
    public Integer getPartiteVinteInTrasferta() {
        TypedQuery<Integer> getPartiteVinteInTrasferta = em.createNamedQuery("getPartiteVinteInTrasferta", Integer.class);
        return getPartiteVinteInTrasferta.getSingleResult();
    }
}
