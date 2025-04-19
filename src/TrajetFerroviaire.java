import java.time.LocalDateTime;

public class TrajetFerroviaire extends Trajet {
    TrajetFerroviaire(String id, Terminal origine, Terminal destination, Compagnie compagnie, LocalDateTime depart, LocalDateTime arrive) {
        super(id, origine, destination, compagnie, depart, arrive);
    }

    public void accept(TrajetVisitor visitor) {
        visitor.visit(this);
    }
}
