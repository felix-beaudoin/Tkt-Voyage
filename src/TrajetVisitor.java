/**
 * Interface du visiteur pour les terminaux.
 */

public interface TrajetVisitor {
    void visit(Vol vol);
    void visit(Itineraire itineraire);
    void visit(TrajetFerroviaire trajetFerroviaire);
}