public class CompagnieNavale extends Compagnie {
    CompagnieNavale(String id, String nom) {
        super(id, nom);
    }

    public String getType() {
        return "Navale";
    }

    public void accept(CompagnieVisitor visitor) {
        visitor.visit(this);
    }

}
