import java.time.LocalDateTime;

public class Vol extends Trajet {
    Vol(String id, Terminal origine, Terminal destination, Compagnie compagnie, LocalDateTime depart, LocalDateTime arrive) {
        super(id, origine, destination, compagnie, depart, arrive);
    }

    public void accept(TrajetVisitor visitor) {
        visitor.visit(this);
    }
}
