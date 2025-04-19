import java.util.HashMap;
import java.util.Map;

/**
 * Fabrique Singleton pour créer et gérer les terminaux.
 */
public class TerminalFactory {
    private static TerminalFactory instance;
    private final Map<String, Terminal> terminals = new HashMap<>();

    private TerminalFactory() {}

    public static TerminalFactory getInstance() {
        if (instance == null) {
            instance = new TerminalFactory();
        }
        return instance;
    }

    public Terminal createTerminal(String type, String id, String city) {
        id = id.toUpperCase();

        if (terminals.containsKey(id)) {
            return terminals.get(id);
        }

        Terminal terminal;
        switch (type.toLowerCase()) {
            case "aéroport":
                terminal = new Aeroport(id, city);
                break;
            case "port":
                terminal = new Port(id, city);
                break;
            case "gare":
                terminal = new Gare(id, city);
                break;
            default:
                throw new IllegalArgumentException("Type inconnu: " + type);
        }
        terminals.put(id, terminal);
        return terminal;
    }

    public Terminal getTerminal(String id) {
        return terminals.get(id.toUpperCase());
    }
}
