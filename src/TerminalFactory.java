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

    public Terminal createTerminal(String type, String code, String city) {
        code = code.toUpperCase();

        if (terminals.containsKey(code)) {
            return terminals.get(code);
        }

        Terminal terminal;
        switch (type.toLowerCase()) {
            case "aeroport":
                terminal = new Aeroport(code, city);
                break;
            case "port":
                terminal = new Port(code, city);
                break;
            case "gare":
                terminal = new Gare(code, city);
                break;
            default:
                throw new IllegalArgumentException("Type inconnu: " + type);
        }
        terminals.put(code, terminal);
        return terminal;
    }

    public Terminal getTerminal(String code) {
        return terminals.get(code.toUpperCase());
    }
}
