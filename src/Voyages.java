import java.util.ArrayList;

public class Voyages implements Subject{
    private StateVoyage state;
    private ArrayList<Obsserver> observers;        

    public Voyages(){
        state = getState();
        observers = new ArrayList<Obsserver>();
    }

    public void attach(Obsserver observer){
        if(observer == null) throw new NullPointerException("Null Observer");
        if(!observers.contains(observer)){
            observers.add(observer);
            observer.setSubject(state);
        }
    }
    public void detach(Obsserver observer){
        if(observer == null) {
            throw new NullPointerException("Null Observer");
        }else{
            observers.remove(observer);
        }
    }
    public void notifyObjects(){
        for (Obsserver o : observers) {
            o.update();
        }
    }
    public StateVoyage getState(){
        return state;
    }
    public void setState(Trajet t, String s){
        if(s == "remove"){
            state.removeVoyage(t);
        }else{
            state.addVoyage(t);
        }
    }
}
