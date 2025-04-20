import java.time.LocalDateTime;

public class Vol extends Trajet {
    Vol(TypeTrajet typeTrajet, String id, Terminal origine, Terminal destination, Compagnie compagnie, LocalDateTime depart, LocalDateTime arrive, Vehicule vehicule) {
        super(typeTrajet, id, origine, destination, compagnie, depart, arrive, vehicule);
    }

    public void accept(TrajetVisitor visitor) {
        visitor.visit(this);
    }
}