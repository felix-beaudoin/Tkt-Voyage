public class Gare extends Terminal {
    Gare(String id, String city) {
        super(id, city);
    }

    @Override
    public String getType() {
        return "Gare";
    }

    @Override
    public void accept(TerminalVisitor visitor) {
        visitor.visit(this);
    }
}
