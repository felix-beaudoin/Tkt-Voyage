import java.util.Stack;

public class GestionnaireCommandes {
    private final Stack<Commande> historique = new Stack<>();

    public void executerCommande(Commande commande) {
        if (commande != null) {
            commande.execute();
            historique.push(commande);
        }
    }

    public void annulerDerniereCommande() {
        if (!historique.isEmpty()) {
            Commande derniere = historique.pop();
            derniere.undo();
        }
    }
}