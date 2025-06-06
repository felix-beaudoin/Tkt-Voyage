import java.util.HashMap;
import java.util.Map;

public class Avion extends Vehicule{
    int nbRangeeDisponible;

    Map<TypeSection, Integer> disponibilite = new HashMap<>();
    Map<TypeSection, Integer> sections = new HashMap<>();// (type, nb de place)
    Map<TypeSection, TypeDisposition> dispositions = new HashMap<>();

    public Avion(TypeTrajet type) {
        super(type);
        nbRangeeDisponible = 100;
    }

    public boolean addSection(TypeSection section, TypeDisposition disposition, int nbRangee) {

        if (sections.containsKey(section) || nbRangeeDisponible < nbRangee)
            return false;
        switch (disposition) {
            case TypeDisposition.S:
                sections.put(section, 3*nbRangee);
                disponibilite.put(section, 3*nbRangee);
                break;
            case TypeDisposition.C:
                sections.put(section, 4*nbRangee);
                disponibilite.put(section, 4*nbRangee);
                break;
            case TypeDisposition.M:
                disponibilite.put(section, 6*nbRangee);
                sections.put(section, 6*nbRangee);
                break;
            case TypeDisposition.L:
                disponibilite.put(section, 10*nbRangee);
                sections.put(section, 10*nbRangee);
                break;
            default:
                throw new IllegalArgumentException("Mauvaise disposition");
        }
        dispositions.put(section, disposition);
        nbRangeeDisponible -= nbRangee;
        return true;
    }

    public boolean deleteSection(TypeSection section, int n) {
        return false;
    }
}
