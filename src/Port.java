public class Port extends Terminal {
    Port(String id, String city) {
        super(id, city);
    }

    @Override
    public String getType() {
        return "Port";
    }

    @Override
    public void accept(TerminalVisitor visitor) {
        visitor.visit(this);
    }
}
