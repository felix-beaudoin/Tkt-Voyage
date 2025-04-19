public class Aeroport extends Terminal {

Aeroport(String id, String city) {
    super(id, city);
}

    @Override
    public String getType() {
        return "Aéroport";
    }

    @Override
    public void accept(TerminalVisitor visitor) {
        visitor.visit(this);
    }
}
