public class CompagnieAerienne extends Compagnie {
    CompagnieAerienne(String id, String nom) {
        super(id, nom);

    }

    public TypeTrajet getType() {
        return TypeTrajet.AÉRIEN;
    }

    public void accept(CompagnieVisitor visitor) {
        visitor.visit(this);
    }
}
