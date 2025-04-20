public abstract class State {
   protected Siege s;
   private String state;

   public State(Siege siege){
       this.s = siege;
       this.state = "ouvert";
   }
}
