public interface CompagnieVisitor {
        void visit(CompagnieAerienne compagnieAerienne);
        void visit(CompagnieNavale compagnieNavale);
        void visit(CompagnieFerroviaire compagnieFerroviaire);
}
