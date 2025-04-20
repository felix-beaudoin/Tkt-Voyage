import java.util.HashMap;
import java.util.Map;

public class Train extends Vehicule {

    Map<TypeSection, Integer> disponibilite = new HashMap<>();
    Map<TypeSection, Integer> sections = new HashMap<>();

    public Train(TypeTrajet type) {
        super(type);
    }

    public boolean addSection(TypeSection section, TypeDisposition t, int n) {
        sections.put(section, sections.getOrDefault(section, 0) + n);
        return true;
    }

    public boolean deleteSection(TypeSection section, int n) {
        sections.put(section, Math.max(0, sections.getOrDefault(section, 0) - n));
        return true;
    }
}