public class AffichageAdminVisiteur implements TrajetVisitor {

    public void visit(Vol vol) {
        StringBuilder sb = createString(vol);

        Avion avion = (Avion) vol.getVehicule();
        avion.sections.get(TypeSection.P);

    }

    public void visit(Itineraire itineraire) {}
    public void visit(TrajetFerroviaire trajetFerroviaire) {}

    private StringBuilder createString(Trajet trajet) {
        StringBuilder sb = new StringBuilder();

        sb.append(trajet.getOrigin().getId())
                .append("-")
                .append(trajet.getDestination().getId())
                .append(":[")
                .append(trajet.getCompagnie().getId())
                .append("]")
                .append(trajet.getId())
                .append('(')
                .append(trajet.getDepart())
                .append("-")
                .append(trajet.getArrive())
                .append(")|");
        return sb;
    }
}
