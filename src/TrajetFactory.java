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
                               LocalDateTime depart, LocalDateTime arrivee) {
        id = id.toUpperCase();

        if (trajets.containsKey(id)) {
            return trajets.get(id);
        }

        Trajet trajet;
        switch (type) {
            case AÉRIEN:
                trajet = new Vol(id, origin, destination, compagnie, depart, arrivee);
                break;
            case NAVAL:
                trajet = new Itineraire(id, origin, destination, compagnie, depart, arrivee);
                break;
            case FERROVIAIRE:
                trajet = new TrajetFerroviaire(id, origin, destination, compagnie, depart, arrivee);
                break;
            default:
                throw new IllegalArgumentException("Type inconnu");
        }
        trajets.put(id, trajet);
        return trajet;
    }
}
