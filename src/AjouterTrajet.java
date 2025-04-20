import java.lang.reflect.Type;
import java.time.LocalDateTime;

public class AjouterTrajet implements Commande {
    private final TypeTrajet type;
    private final String id;
    private final Terminal origin;
    private final Terminal destination;
    private final Compagnie compagnie;
    private final LocalDateTime depart;
    private final LocalDateTime arrive;
    private final Vehicule vehicule;

    AjouterTrajet(TypeTrajet type, String id, Terminal origin, Terminal destination, Compagnie compagnie, LocalDateTime depart, LocalDateTime arrive, Vehicule vehicule) {
        this.type = type;
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.compagnie = compagnie;
        this.depart = depart;
        this.arrive = arrive;
        this.vehicule = vehicule;
    }

    public void execute() {
        TrajetFactory trajetFactory = TrajetFactory.getInstance();
        trajetFactory.createTrajet(type, id, origin, destination, compagnie, depart, arrive, vehicule);
    }

    public void undo() {
        TrajetFactory trajetFactory = TrajetFactory.getInstance();
        trajetFactory.deleteTrajet(id);
    }


}
