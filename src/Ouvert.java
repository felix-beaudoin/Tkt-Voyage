public class Ouvert extends State{
    public Ouvert(Siege s){
        super(s);
    }

    public void setOuvertState(){
        this.s.setState("ouvert");
    }
}
