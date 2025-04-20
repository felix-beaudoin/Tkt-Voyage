public class Siege {
    private State state;

    public Siege(){
        state = new Ouvert(this);
    }

    public void setState(String s){
        switch (s) {
            case "ouvert":
                state.name = "ouvert";
                break;
            case "paiement":
                state.name = "paiement";
                break;
            case "reserver":
                state.name = "reserver";
                break;
        
            default:
                state.name = "ouvert";
                break;
        }
    }
}
