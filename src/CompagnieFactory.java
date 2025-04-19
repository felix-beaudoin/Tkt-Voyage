import java.util.HashMap;
import java.util.Map;

public class CompagnieFactory {
    private static CompagnieFactory instance;
    private final Map<String, Compagnie> compagnies = new HashMap<>();

    private CompagnieFactory() {}

    public static CompagnieFactory getInstance() {
        if (instance == null) {
            instance = new CompagnieFactory();
        }
        return instance;
    }

    public Compagnie createCompagnie(String type, String id, String nom) {
        id = id.toUpperCase();

        if (compagnies.containsKey(id)) {
            return compagnies.get(id);
        }

        Compagnie compagnie;
        switch (type.toLowerCase()) {
            case "aérienne":
                compagnie = new CompagnieAerienne(id, nom);
                break;
            case "navale":
                compagnie = new CompagnieNavale(id, nom);
                break;
            case "ferroviaire":
                compagnie = new CompagnieFerroviaire(id, nom);
                break;
            default:
                throw new IllegalArgumentException("Type inconnu: " + type);
        }
        compagnies.put(id, compagnie);
        return compagnie;
    }

    public Compagnie getCompagnie(String id) {
        return compagnies.get(id.toUpperCase());
    }


}
