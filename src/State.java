public abstract class State {
   protected Siege s;
   protected String name;

   public State(Siege siege){
       this.s = siege;
       this.name = "ouvert";
   }
}
