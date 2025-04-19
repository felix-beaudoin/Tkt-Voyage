import java.util.HashMap;
import java.util.Map;

public class Avion {
    int nbRangeeDisponible;
    public enum TypeSection {
        F, // Première
        A, // Affaire
        P, // Économique Premium
        E  // Économique
    }

    public enum TypeDisposition {
        S, C, M, L
    }

    Map<TypeSection, Integer> sections = new HashMap<>();

    public Avion()   {
        nbRangeeDisponible = 100;
    }

    public boolean addSection(TypeSection section, TypeDisposition disposition, int nbRangee) {
        if (sections.containsKey(section) || nbRangeeDisponible < nbRangee)
            return false;
        switch (disposition) {
            case TypeDisposition.S:
                sections.put(section, 3*nbRangee);
                break;
            case TypeDisposition.C:
                sections.put(section, 4*nbRangee);
                break;
            case TypeDisposition.M:
                sections.put(section, 6*nbRangee);
                break;
            case TypeDisposition.L:
                sections.put(section, 10*nbRangee);
                break;
            default:
                throw new IllegalArgumentException("Mauvaise disposition");
        }
        nbRangeeDisponible -= nbRangee;
        return true;
    }


}
