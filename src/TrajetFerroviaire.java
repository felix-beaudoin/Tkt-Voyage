import java.time.LocalDateTime;

public class TrajetFerroviaire extends Trajet {
    TrajetFerroviaire(TypeTrajet type, String id, Terminal origine, Terminal destination, Compagnie compagnie, LocalDateTime depart, LocalDateTime arrive, Vehicule vehicule) {
        super(type, id, origine, destination, compagnie, depart, arrive, vehicule);
    }

    public void accept(TrajetVisitor visitor) {
        visitor.visit(this);
    }
}