public class ModifierTerminale implements Commande {

    private final String id;
    private final String city;
    private Terminal oldTerminal;

    ModifierTerminale(String id, String city) {
        this.id = id;
        this.city = city;
    }

    public void execute() {
        TerminalFactory terminalFactory = TerminalFactory.getInstance();
        oldTerminal = terminalFactory.modifyTerminal(id, city);
    }

    public void undo() {
        TerminalFactory terminalFactory = TerminalFactory.getInstance();
        terminalFactory.deleteTerminal(id);
        terminalFactory.createTerminal(oldTerminal.getType(), oldTerminal.getId(), oldTerminal.getCity());
    }
}