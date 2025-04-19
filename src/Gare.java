public class Gare extends Terminal {
    Gare(String id, String city) {
        super(id, city);
    }

    @Override
    public TypeTrajet getType() {
        return TypeTrajet.FERROVIAIRE;
    }

    @Override
    public void accept(TerminalVisitor visitor) {
        visitor.visit(this);
    }
}
