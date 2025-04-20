public class CompagnieNavale extends Compagnie {
    CompagnieNavale(String id, String nom) {
        super(id, nom);
    }

    public TypeTrajet getType() {
        return TypeTrajet.NAVAL;
    }

    public void accept(CompagnieVisitor visitor) {
        visitor.visit(this);
    }
}
