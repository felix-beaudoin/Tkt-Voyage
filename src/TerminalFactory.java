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

    public Terminal createTerminal(TypeTrajet type, String id, String city) {
        id = id.toUpperCase();

        if (terminals.containsKey(id)) {
            return terminals.get(id);
        }

        Terminal terminal;
        switch (type) {
            case TypeTrajet.AÉRIEN:
                terminal = new Aeroport(id, city);
                break;
            case TypeTrajet.NAVAL:
                terminal = new Port(id, city);
                break;
            case TypeTrajet.FERROVIAIRE:
                terminal = new Gare(id, city);
                break;
            default:
                throw new IllegalArgumentException("Type inconnu: " + type);
        }
        terminals.put(id, terminal);
        return terminal;
    }

    public Terminal deleteTerminal(String id) {
        id = id.toUpperCase();

        if (terminals.containsKey(id)) {
            return terminals.remove(id);
        }
        return null;
    }

    public Terminal modifyTerminal(String id, String nom) {
        id = id.toUpperCase();
        Terminal terminal;
        if (terminals.containsKey(id)) {
            terminal = terminals.remove(id);
        } else {
            return null;
        }
        Terminal newTerminal = createTerminal(terminal.getType(), id, nom);
        terminals.put(id, newTerminal);
        return terminal;

    }

    public Terminal getTerminal(String id) {
        return terminals.get(id.toUpperCase());
    }
}
