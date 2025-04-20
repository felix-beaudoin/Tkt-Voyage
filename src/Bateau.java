import java.util.HashMap;
import java.util.Map;

public class Bateau extends Vehicule {

    Map<TypeSection, Integer> disponibiliteSection = new HashMap<>();
    Map<TypeSection, Integer> sections = new HashMap<>();

    public Bateau(TypeTrajet type)   {
        super(type);
        disponibiliteSection.put(TypeSection.I, 4);
        disponibiliteSection.put(TypeSection.O, 2);
        disponibiliteSection.put(TypeSection.S, 5);
        disponibiliteSection.put(TypeSection.F, 6);
        disponibiliteSection.put(TypeSection.D, 6);
    }

    public boolean addSection(TypeSection section, TypeDisposition t, int n) {
        sections.put(section, sections.get(section) + n);
        return true;
    }

    public boolean deleteSection(TypeSection section, int n) {
        sections.put(section, Math.max(sections.get(section) - n, 0));
        return true;
    }
}
