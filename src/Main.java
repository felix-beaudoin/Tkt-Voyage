import java.util.Scanner;

public class Main {

    static GestionnaireCommandes gestionnaireCommandes = new GestionnaireCommandes();

    public static void main(String[] args) {
        boolean boucle = true;
        System.out.println("Bonjour et bienvenue au planificateur de voyage");
        while (boucle) {
            System.out.println("Que voulez-vous faire?");
            System.out.println("Faire une action sur (C)ompagnie, (L)ieu, (T)rajet? (V)oir des trajets? (U)ndo? (Q)uitter?");
            Commande commande = null;
            Scanner scanner = new Scanner(System.in);
            String action = scanner.nextLine();
            switch (action) {
                case "C":
                    commande = actionCompagnie();
                    break;
                case "L":
                    commande = actionLieu();
                    break;
                case "T":
                    commande = actionTrajet();
                    break;
                case "V":
                    commande = actionAffichage();
                    break;
                case "Q":
                    boucle = false;
                case "U":
                    gestionnaireCommandes.annulerDerniereCommande();
                default:
                    boucle = false;
            }
            gestionnaireCommandes.executerCommande(commande);
        }
    }

    public static Commande actionCompagnie() {
        System.out.println("Compagnie (A)érienne, (N)avale ou (F)erroviaire?");
        Commande commande = null;
        TypeTrajet type = null;
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();
        switch (action) {
            case "A":
                type = TypeTrajet.AÉRIEN;
                break;
            case "N":
                type = TypeTrajet.NAVAL;
                break;
            case "F":
                type = TypeTrajet.FERROVIAIRE;
                break;
        }

        System.out.println("(A)jouter, (S)upprimer ou (M)odifier?");
        action = scanner.nextLine();
        switch (action) {
            case "A":
                commande = ajouterCompagnie(type);
                break;
            case "S":
                commande = supprimerCompagnie(type);
                break;
            case "M":
                commande = modifierCompagnie(type);
                break;
        }
        return commande;
    }


    private static Commande ajouterCompagnie(TypeTrajet type) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom de la compagnie?");
        String nom = scanner.nextLine();
        System.out.println("Id de compagnie?");
        String id = scanner.nextLine();

        AjouterCompagnie ajouterCompagnie = new AjouterCompagnie(type, id, nom);
        return ajouterCompagnie;
    }

    private static Commande modifierCompagnie(TypeTrajet type) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nouveau nom de la compagnie?");
        String nom = scanner.nextLine();
        System.out.println("Id de compagnie à modifier?");
        String id = scanner.nextLine();

        ModifierCompagnie ajouterCompagnie = new ModifierCompagnie(id, nom);
        return ajouterCompagnie;
    }

    private static Commande supprimerCompagnie(TypeTrajet type) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id de la compagnie à supprimer?");
        String id = scanner.nextLine();

        SupprimerCompagnie supprimerCompagnie = new SupprimerCompagnie(id);
        return supprimerCompagnie;
    }
    public static Commande actionLieu() {return null;}
    public static Commande actionTrajet() {return null;}
    public static Commande actionAffichage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ID du trajet aerien, naval ou ferroviaire?");
        AffichageAdminVisiteur affichageAdminVisiteur = new AffichageAdminVisiteur();
        String id = scanner.nextLine();

        switch (TrajetFactory.getInstance().getTrajet(id).getTypeTrajet()) {
            case TypeTrajet.AÉRIEN:
                affichageAdminVisiteur.visit((Vol) TrajetFactory.getInstance().getTrajet(id));
                break;
            case TypeTrajet.NAVAL:
                affichageAdminVisiteur.visit((Itineraire) TrajetFactory.getInstance().getTrajet(id));
                break;
            case TypeTrajet.FERROVIAIRE:
                affichageAdminVisiteur.visit((TrajetFerroviaire) TrajetFactory.getInstance().getTrajet(id));
                break;
        }
        return null;
    }
}