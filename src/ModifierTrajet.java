import java.time.LocalDateTime;

public class ModifierTrajet implements Commande {

    private final String id;
    private final Terminal origin;
    private final Terminal destination;
    private final LocalDateTime depart;
    private final LocalDateTime arrive;
    private Trajet oldTrajet;
    private final Vehicule vehicule;

    ModifierTrajet(String id, Terminal origin, Terminal destination, LocalDateTime depart, LocalDateTime arrivee, Vehicule vehicule) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.depart = depart;
        this.arrive = arrivee;
        this.vehicule = vehicule;
    }

    public void execute() {
        TrajetFactory trajetFactory = TrajetFactory.getInstance();
        oldTrajet = trajetFactory.modifyTrajet(id, origin, destination, depart, arrive, vehicule);
    }

    public void undo() {
        TrajetFactory trajetFactory = TrajetFactory.getInstance();
        trajetFactory.modifyTrajet(oldTrajet.getId(), oldTrajet.getOrigin(),
                oldTrajet.getDestination(), oldTrajet.getDepart(), oldTrajet.getArrive(), vehicule);
    }

}
