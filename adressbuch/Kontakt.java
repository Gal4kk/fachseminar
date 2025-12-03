/**
 * Klasse zur Repräsentation eines Kontakts im Adressbuch.
 */
public class Kontakt {
    private String vorname;
    private String nachname;
    private String telNr;

    /**
     * Konstruktor für einen Kontakt.
     * 
     * @param vorname Der Vorname des Kontakts
     * @param nachname Der Nachname des Kontakts
     * @param telNr Die Telefonnummer des Kontakts
     */
    public Kontakt(String vorname, String nachname, String telNr) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.telNr = telNr;
    }

    /**
     * Gibt den Vornamen zurück.
     * 
     * @return Vorname
     */
    public String getVorname() {
        return vorname;
    }

    /**
     * Gibt den Nachnamen zurück.
     * 
     * @return Nachname
     */
    public String getNachname() {
        return nachname;
    }

    /**
     * Gibt die Telefonnummer zurück.
     * 
     * @return Telefonnummer
     */
    public String getTelNr() {
        return telNr;
    }

    /**
     * Gibt eine String-Repräsentation des Kontakts zurück.
     * 
     * @return Kontakt als String
     */
    @Override
    public String toString() {
        return vorname + " " + nachname + " - " + telNr;
    }
}
