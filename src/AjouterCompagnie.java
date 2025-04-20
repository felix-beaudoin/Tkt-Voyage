public class AjouterCompagnie implements Commande {

    private final TypeTrajet typeTrajet;
    private final String id;
    private final String nom;


    public AjouterCompagnie(TypeTrajet typeTrajet, String id, String nom) {
        this.typeTrajet = typeTrajet;
        this.id = id;
        this.nom = nom;
    }

    public void execute(){
        CompagnieFactory compagnieFactory = CompagnieFactory.getInstance();
        compagnieFactory.createCompagnie(typeTrajet, id, nom);
    }

    public void undo() {
        CompagnieFactory compagnieFactory = CompagnieFactory.getInstance();
        compagnieFactory.deleteCompagnie(id);
    }
}
