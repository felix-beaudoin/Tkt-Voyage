public class Transmetteur implements Obsserver{
    private StateVoyage subject;
    private String name;


    public Transmetteur(String s){
        name = s;
    }
    public void update(){
        //Update Terminal CLI for the client or admin
    }
    public void setSubject(StateVoyage s){
        subject = s;
    }
    
}
