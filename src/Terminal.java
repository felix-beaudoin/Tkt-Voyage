/**
 * Classe abstraite représentant un terminal (aéroport, port, gare).
 */
public abstract class Terminal  {

    private final String id; // six lettres uniques
    private String city;

    public Terminal(String id, String city) {
        this.id = id;
        this.city = city;
    }

    public String getCode() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public abstract TypeTrajet getType();

    public String toString() {
        return String.format( getType() + " - [" + getCode() + "] " + getCity() );
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Terminal terminal)) return false;
        return id.equals(terminal.id);
    }

    public abstract void accept(TerminalVisitor visitor); // Patron visiteur

}
