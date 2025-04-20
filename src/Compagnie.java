import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Compagnie  {

    private final String id;
    private String nom;
    private final Map<String, Trajet> trajets = new HashMap<>();

    public Compagnie(String id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public String getId() { return id; }

    public String getNom() { return nom; }

    public abstract TypeTrajet getType();

    public String toString() {
        return String.format( getType() + " - [" + getId() + "] " + getNom());
    }

    public abstract void accept(CompagnieVisitor visitor); // Patron visiteur

    public void addTrajet(Trajet trajet) { trajets.put(trajet.getId(), trajet); }

    public Trajet removeTrajet(Trajet trajet) { return trajets.remove(trajet.getId()); }
    public Trajet removeTrajet(String id) { return trajets.remove(id); }

    public Map<String, Trajet> getTrajets() { return trajets; }
}
