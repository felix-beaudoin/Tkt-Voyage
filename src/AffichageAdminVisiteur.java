public class AffichageAdminVisiteur implements TrajetVisitor {

    public void visit(Vol vol) {
        StringBuilder sb = createString(vol);

        Avion avion = (Avion) vol.getVehicule();

        for (TypeSection type : avion.sections.keySet()) {
            sb.append("|")
                .append(type)
                .append(avion.disponibilite.get(type))
                .append("(")
                .append(avion.sections.get(type))
                .append("/")
                .append(avion.dispositions.get(type))
                .append(")")
                .append("100$");
        }
    }

    public void visit(Itineraire itineraire) {
        StringBuilder sb = createString(itineraire);

        Bateau bateau = (Bateau) itineraire.getVehicule();

        for (TypeSection type : bateau.disponibiliteSection.keySet()) {
            sb.append("|")
                    .append(type)
                    .append("(")
                    .append(bateau.disponibiliteSection.get(type))
                    .append("/")
                    .append(bateau.sections.get(type))
                    .append(")");
        }
    }
    public void visit(TrajetFerroviaire trajetFerroviaire) {
        StringBuilder sb = createString(trajetFerroviaire);

        Train train = (Train) trajetFerroviaire.getVehicule();

        for (TypeSection type : train.sections.keySet()) {
            sb.append("|")
                    .append(type)
                    .append("(")
                    .append(train.disponibilite.get(type))
                    .append("/")
                    .append(train.sections.get(type))
                    .append(")");
        }

    }

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
                .append(")");
        return sb;
    }
}
