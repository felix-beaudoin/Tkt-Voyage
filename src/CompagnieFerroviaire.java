public class CompagnieFerroviaire extends Compagnie {
    CompagnieFerroviaire(String id, String nom) {
        super(id, nom);
    }

    public TypeTrajet getType() {
        return TypeTrajet.FERROVIAIRE;
    }

    public void accept(CompagnieVisitor visitor) {
        visitor.visit(this);
    }
}