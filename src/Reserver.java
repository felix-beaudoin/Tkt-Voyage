public class Reserver extends State{
    public Reserver(Siege s){
        super(s);
    }

    public void setReserverState(){
        this.s.setState("reserver");
    }
}