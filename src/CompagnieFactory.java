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

    public Compagnie createCompagnie(TypeTrajet type, String id, String nom) {
        id = id.toUpperCase();

        if (compagnies.containsKey(id)) {
            return compagnies.get(id);
        }

        Compagnie compagnie;
        switch (type) {
            case TypeTrajet.AÉRIEN:
                compagnie = new CompagnieAerienne(id, nom);
                break;
            case TypeTrajet.NAVAL:
                compagnie = new CompagnieNavale(id, nom);
                break;
            case TypeTrajet.FERROVIAIRE:
                compagnie = new CompagnieFerroviaire(id, nom);
                break;
            default:
                throw new IllegalArgumentException("Type inconnu: " + type);
        }
        compagnies.put(id, compagnie);
        return compagnie;
    }

    public Compagnie deleteCompagnie(String id) {
        id = id.toUpperCase();

        if (compagnies.containsKey(id)) {
            return compagnies.remove(id);
        }
        return null;
    }

    public Compagnie modifyCompagnie(String id, String nom) {
        id = id.toUpperCase();
        Compagnie compagnie;
        if (compagnies.containsKey(id)) {
            compagnie = compagnies.get(id);
            compagnies.remove(id);
        } else {
            return null;
        }
        Compagnie newCompagnie = createCompagnie(compagnie.getType(), id, nom);
        compagnies.put(id, newCompagnie);
        return compagnie;

    }

    public Compagnie getCompagnie(String id) {
        return compagnies.get(id.toUpperCase());
    }


}
