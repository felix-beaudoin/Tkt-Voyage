import java.time.LocalDateTime;

public abstract class Trajet {
    private final String id;
    private final Terminal origin;
    private final Terminal destination;
    private final Compagnie compagnie;
    private final LocalDateTime depart;
    private final LocalDateTime arrive;

    protected Trajet(String id, Terminal origine, Terminal destination, Compagnie compagnie,
                     LocalDateTime depart, LocalDateTime arrive) {
        if (origine.equals(destination)) {
            throw new IllegalArgumentException("Le terminal d'origine et de destination doivent être différents");
        }
        this.id = id;
        this.origin = origine;
        this.destination = destination;
        this.compagnie = compagnie;
        this.depart = depart;
        this.arrive = arrive;
    }

    public String getId() {
        return id;
    }

    public Terminal getOrigin() {
        return origin;
    }

    public Terminal getDestination() {
        return destination;
    }

    public Compagnie getCompagnie() {
        return compagnie;
    }

    public LocalDateTime getDepart() {
        return depart;
    }

    public LocalDateTime getArrive() {
        return arrive;
    }

    public long getDureeEnMinutes() {
        return java.time.Duration.between(depart, arrive).toMinutes();
    }

    public abstract void accept(TrajetVisitor visitor);

    public String toString() {
        return String.format(origin.getCode() + '-' + destination.getCode() + ":[" + compagnie.getNom() + "]" + id + '(' + depart + '-' + arrive + ')');
    }
}
