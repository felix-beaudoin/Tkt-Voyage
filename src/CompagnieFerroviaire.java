public class CompagnieFerroviaire extends Compagnie {
    CompagnieFerroviaire(String id, String nom) {
        super(id, nom);
    }

    public String getType() {
        return "Aérienne";
    }

    public void accept(CompagnieVisitor visitor) {
        visitor.visit(this);
    }
}