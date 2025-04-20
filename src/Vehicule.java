

public abstract class Vehicule {
    public final TypeTrajet type;

    Vehicule(TypeTrajet type){
        this.type = type;
    }

    public abstract boolean addSection(TypeSection section, TypeDisposition t, int n);
    public abstract boolean deleteSection(TypeSection section, int n);
}