import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class TrajetFactory {
    private static TrajetFactory instance;
    private final Map<String, Trajet> trajets = new HashMap<>();

    private TrajetFactory() {}

    public static TrajetFactory getInstance() {
        if (instance == null) {
            instance = new TrajetFactory();
        }
        return instance;
    }

    public Trajet createTrajet(TypeTrajet type, String id, Terminal origin, Terminal destination, Compagnie compagnie,
                               LocalDateTime depart, LocalDateTime arrivee, Vehicule vehicule) {
        id = id.toUpperCase();

        if (trajets.containsKey(id)) {
            return trajets.get(id);
        }

        Trajet trajet;
        switch (type) {
            case AÉRIEN:
                trajet = new Vol(type, id, origin, destination, compagnie, depart, arrivee, vehicule);
                break;
            case NAVAL:
                trajet = new Itineraire(type, id, origin, destination, compagnie, depart, arrivee, vehicule);
                break;
            case FERROVIAIRE:
                trajet = new TrajetFerroviaire(type, id, origin, destination, compagnie, depart, arrivee, vehicule);
                break;
            default:
                throw new IllegalArgumentException("Type inconnu");
        }
        trajets.put(id, trajet);
        return trajet;
    }

    public Trajet deleteTrajet(String id) {
        Trajet trajet = trajets.get(id);
        Compagnie compagnie = trajet.getCompagnie();
        compagnie.getTrajets().remove(trajet);
        return trajets.remove(id);

    }

    public Trajet modifyTrajet(String id, Terminal origin, Terminal destination, LocalDateTime depart, LocalDateTime arrive, Vehicule vehicule) {
        id = id.toUpperCase();
        Trajet trajet;
        if (trajets.containsKey(id)) {
            trajet = trajets.get(id);
            trajets.remove(id);
        } else {
            return null;
        }
        Trajet newTrajet = createTrajet(trajet.getTypeTrajet(), id, origin, destination, trajet.getCompagnie(), depart, arrive, vehicule);
        trajets.put(id, newTrajet);
        return trajet;
    }
}
