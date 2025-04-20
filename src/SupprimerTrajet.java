public class SupprimerTrajet implements Commande {


    private final String id;
    private Trajet oldTrajet;

    SupprimerTrajet(String id) {
        this.id = id;
    }

    public void execute() {
        TrajetFactory trajetFactory = TrajetFactory.getInstance();
        this.oldTrajet = trajetFactory.deleteTrajet(id);
    }

    public void undo() {
        TrajetFactory trajetFactory = TrajetFactory.getInstance();
        trajetFactory.createTrajet(oldTrajet.getTypeTrajet(), oldTrajet.getId(), oldTrajet.getOrigin(),
                oldTrajet.getDestination(), oldTrajet.getCompagnie(), oldTrajet.getDepart(), oldTrajet.getArrive(), oldTrajet.getVehicule());
    }

}
