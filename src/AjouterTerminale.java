public class AjouterTerminale implements Commande {

    private final TypeTrajet typeTrajet;
    private final String id;
    private final String city;

    AjouterTerminale(TypeTrajet typeTrajet, String id, String city) {
        this.typeTrajet = typeTrajet;
        this.id = id;
        this.city = city;
    }

    public void execute() {
        TerminalFactory terminalFactory = TerminalFactory.getInstance();
        terminalFactory.createTerminal(typeTrajet, id, city);
    }

    public void undo() {
        TerminalFactory terminalFactory = TerminalFactory.getInstance();
        terminalFactory.deleteTerminal(id);
    }
}
