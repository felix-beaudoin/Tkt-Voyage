public class ModifierCompagnie implements Commande{

    private final String id;
    private final String nom;
    private Compagnie oldCompagnie;

    public ModifierCompagnie(String id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public void execute(){
        CompagnieFactory compagnieFactory = CompagnieFactory.getInstance();
        oldCompagnie = compagnieFactory.modifyCompagnie(id, nom);
    }

    public void undo() {
        CompagnieFactory compagnieFactory = CompagnieFactory.getInstance();
        compagnieFactory.deleteCompagnie(id);
        compagnieFactory.createCompagnie(oldCompagnie.getType(), oldCompagnie.getId(), oldCompagnie.getNom());
    }
}