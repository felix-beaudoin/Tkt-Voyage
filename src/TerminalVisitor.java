/**
 * Interface du visiteur pour les terminaux.
 */

public interface TerminalVisitor {
    void visit(Aeroport aeroport);
    void visit(Port port);
    void visit(Gare gare);
}