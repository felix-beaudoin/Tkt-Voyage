public abstract class Compagnie  {

    private final String id;
    private String nom;


    public Compagnie(String id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public String getId() { return id; }

    public String getNom() { return nom; }

    public abstract TypeTrajet getType();

    public String toString() {
        return String.format( getType() + " - [" + getId() + "] " + getNom());
    }

    public abstract void accept(CompagnieVisitor visitor); // Patron visiteur

}
