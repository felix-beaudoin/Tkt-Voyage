public class Aeroport extends Terminal {

Aeroport(String id, String city) {
    super(id, city);
}

    @Override
    public TypeTrajet getType() {
        return TypeTrajet.AÉRIEN;
    }

    @Override
    public void accept(TerminalVisitor visitor) {
        visitor.visit(this);
    }
}
