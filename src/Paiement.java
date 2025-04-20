public class Paiement extends State{
    public Paiement(Siege s){
        super(s);
    }

    public void setPaiementState(){
        this.s.setState("paiement");
    }
}
