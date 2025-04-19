/**
 * Classe abstraite représentant un terminal (aéroport, port, gare).
 */
public abstract class Terminal extends Observable {



    private final String code; // six lettres uniques
    private final String city;

    public Terminal(String code, String city) {
        if (code == null || code.length() != 3) {
            throw new IllegalArgumentException("Le code doit contenir exactement 6 lettres majuscules");
        }
        this.code = code;
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public String getCity() {
        return city;
    }

    public abstract String getType();

    public String toString() {
        return String.format( getType() + " - [" + code + "] " + city );
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Terminal terminal)) return false;
        return code.equals(terminal.code);
    }

    public abstract void accept(TerminalVisitor visitor); // Patron visiteur

}
