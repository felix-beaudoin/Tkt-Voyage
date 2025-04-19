public class Gare extends Terminal {
    Gare(String code, String city) {
        super(code, city);
    }

    @Override
    public String getType() {
        return "";
    }

    @Override
    public void accept(TerminalVisitor visitor) {

    }
}
