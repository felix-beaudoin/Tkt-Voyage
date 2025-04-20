import java.util.ArrayList;

public class StateVoyage {

    private Trajet lastVoyage;
    private ArrayList<Trajet> listeVoyage;

    private StateVoyage(){
        listeVoyage = new ArrayList<Trajet>();
    }

    public void addVoyage(Trajet t){
        listeVoyage.add(t);
        lastVoyage = t;
    }
    public void removeVoyage(Trajet t){
        listeVoyage.remove(t);
        lastVoyage = t;
    }
    public Trajet getLastVoyage(){
       return lastVoyage; 
    }
    public void createInstance(){
        if(listeVoyage == null){
            new StateVoyage();
        }else{
            System.out.println("Error404");
        }
    }
}
