public class SupprimerCompagnie implements Commande{
    private final String id;
    private Compagnie oldCompagnie;


    public SupprimerCompagnie(String id) {
        this.id = id;
    }

    public void execute(){
        CompagnieFactory compagnieFactory = CompagnieFactory.getInstance();
        this.oldCompagnie = compagnieFactory.deleteCompagnie(id);
    }

    public void undo() {
        CompagnieFactory compagnieFactory = CompagnieFactory.getInstance();
        compagnieFactory.createCompagnie(oldCompagnie.getType(), oldCompagnie.getId(), oldCompagnie.getNom());
    }
}

