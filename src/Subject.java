public interface Subject {
    public void attach(Obsserver observer);
    public void detach(Obsserver observer);
    public void notifyObjects();
}
