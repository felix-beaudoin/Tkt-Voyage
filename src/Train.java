import java.util.HashMap;
import java.util.Map;

public class Train {

    public enum TypeSection {
        P, E
    }

    Map<TypeSection, Integer> sections = new HashMap<>();

    public Train() { }

    public void addSection(TypeSection section, int n) {
        sections.put(section, sections.getOrDefault(section, 0) + n);
    }

    public void deleteSection(TypeSection section, int n) {
        sections.put(section, Math.max(0, sections.getOrDefault(section, 0) - n));
    }
}