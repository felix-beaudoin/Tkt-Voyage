public class Port extends Terminal {
    Port(String id, String city) {
        super(id, city);
    }

    @Override
    public TypeTrajet getType() {
        return TypeTrajet.NAVAL;
    }

    @Override
    public void accept(TerminalVisitor visitor) {
        visitor.visit(this);
    }
}
