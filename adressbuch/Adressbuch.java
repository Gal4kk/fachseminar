/**
 * Controller-Klasse für das Adressbuch.
 * Verwaltet die Kontaktliste und stellt Methoden zur Manipulation bereit.
 * Trennt die Geschäftslogik von der GUI-Darstellung.
 */
public class Adressbuch {
    /*aufg* 1
    // TODO: Erstelle eine Objektvariable "kontaktListe" vom Typ List<Kontakt>
    *aufg*/
    /*aufg* 2
    // TODO: Erstelle eine Objektvariable "kontaktListe" vom Typ List<Kontakt>
    //private ____<Kontakt> kontaktListe;
    *aufg*/
    //ml*
    private List<Kontakt> kontaktListe;
    //*ml
    
    /**
     * Konstruktor des Controllers.
     * Initialisiert eine leere Kontaktliste.
     */
    public Adressbuch() {
        /*aufg* 1
        // TODO: Initialisiere die kontaktListe als neue leere Liste
        *aufg*/

        /*aufg* 2
        // TODO: Initialisiere die kontaktListe als neue leere Liste
        //kontaktListe = new ___<Kontakt>();
        *aufg*/

        //ml*
        kontaktListe = new List<Kontakt>();
        //*ml
    }
    
    /**
     * Erstellt Beispieldaten für Tests und Demonstration.
     */
    public void erstelleBeispieldaten() {
        kontaktHinzufuegen("Max", "Mustermann", "0221-123456");
        kontaktHinzufuegen("Anna", "Schmidt", "0211-234567");
        kontaktHinzufuegen("Peter", "Müller", "0221-345678");
        kontaktHinzufuegen("Laura", "Weber", "0211-456789");
        kontaktHinzufuegen("Tim", "Wagner", "0221-567890");
        kontaktHinzufuegen("Sarah", "Becker", "0211-678901");
        kontaktHinzufuegen("Marc", "Hoffmann", "0221-789012");
        kontaktHinzufuegen("Julia", "Schneider", "0211-890123");
        kontaktHinzufuegen("Felix", "Fischer", "0221-901234");
        kontaktHinzufuegen("Lisa", "Richter", "0211-012345");
    }
    
    /**
     * Fügt einen neuen Kontakt zur Liste hinzu.
     * 
     * @param vorname Der Vorname des Kontakts
     * @param nachname Der Nachname des Kontakts
     * @param telNr Die Telefonnummer des Kontakts
     */
    public void kontaktHinzufuegen(String vorname, String nachname, String telNr) {
        /*aufg* 1
        // TODO: Erstelle ein neues Kontakt-Objekt mit den übergebenen Parametern
        // TODO: Füge den neuen Kontakt am Ende der Liste hinzu (mit append)
        *aufg*/
        /*aufg* 2
        // TODO: Erstelle ein neues Kontakt-Objekt mit den übergebenen Parametern
        // TODO: Füge den neuen Kontakt am Ende der Liste hinzu (mit append)
        //Kontakt neuerKontakt = new Kontakt(___, ___, ___);
        //kontaktListe.___(_____);
        *aufg*/
        //ml*
        Kontakt neuerKontakt = new Kontakt(vorname, nachname, telNr);
        kontaktListe.append(neuerKontakt);
        //*ml
    }
 
    /**
     * Springt zum ersten Kontakt in der Liste.
     */
    public void zumAnfang() {
        /*aufg* 1
        // TODO: Setze den Zeiger auf das erste Element der Liste
        *aufg*/
        /*aufg* 2
        // TODO: Setze den Zeiger auf das erste Element der Liste
        //kontaktListe.___();
        *aufg*/
        //ml*
        kontaktListe.toFirst();
        //*ml
    }
    
    /**
     * Geht zum nächsten Kontakt in der Liste.
     */
    public void zumNaechsten() {
        /*aufg* 1
        // TODO: Bewege den Zeiger zum nächsten Element
        *aufg*/
        /*aufg* 2
        // TODO: Bewege den Zeiger zum nächsten Element
        //kontaktListe.___();
        *aufg*/
        //ml*
        kontaktListe.next();
        //*ml
    }
    
    /**
     * Springt zum letzten Kontakt in der Liste.
     */
    public void zumEnde() {
        /*aufg* 1
        // TODO: Setze den Zeiger auf das letzte Element der Liste
        *aufg*/
        /*aufg* 2
        // TODO: Setze den Zeiger auf das letzte Element der Liste
        //kontaktListe.___();
        *aufg*/
        //ml*
        kontaktListe.toLast();
        //*ml
    }
    
    /**
     * Gibt den aktuellen Kontakt zurück.
     * 
     * @return Der aktuelle Kontakt oder null, wenn kein Zugriff besteht
     */
    public Kontakt getAktuellerKontakt() {
        /*aufg* 1
        // TODO: Inhalt der Liste zurückgeben
        return null;
        *aufg*/
        /*aufg* 2
        // TODO: Inhalt der Liste zurückgeben
        //return kontaktListe.___();
        return null; // Rückgabewert anpassen
        *aufg*/
        //ml*
        return kontaktListe.getContent();
        //*ml
    }
    
    /**
     * Sucht einen Kontakt nach Vorname und setzt ihn als aktuelles Element.
     * 
     * @param vorname Der zu suchende Vorname
     * @return true, wenn ein Kontakt gefunden wurde, sonst false
     */
    public boolean sucheNachVorname(String vorname) {
        /*aufg* 1
        // TODO: Setze den Zeiger auf das erste Element
        // TODO: Durchlaufe die Liste mit einer while-Schleife
        // TODO: Prüfe für jeden Kontakt, ob der Vorname mit dem Suchbegriff übereinstimmt (nutze die Methode equals() der String-Klasse)
        // TODO: Wenn ja, gib true zurück
        // TODO: Gehe zum nächsten Element
        // TODO: Wenn kein Kontakt gefunden wurde, gib false zurück
        return false;
        *aufg*/
        /*aufg* 2
        // TODO: Setze den Zeiger auf das erste Element
        // TODO: Durchlaufe die Liste mit einer while-Schleife
        // TODO: Prüfe für jeden Kontakt, ob der Vorname mit dem Suchbegriff übereinstimmt
        // TODO: Wenn ja, gib true zurück
        // TODO: Gehe zum nächsten Element
        // TODO: Wenn kein Kontakt gefunden wurde, gib false zurück
        //kontaktListe.___();
        //
        //while (kontaktListe.___()) {
        //    Kontakt k = kontaktListe.___();
        //    if (k.getVorname().equals(vorname)) {
        //        return ___;
        //    }
        //    kontaktListe.___();
        //}
        //
        return false; // Rückgabewert anpassen
        *aufg*/
        //ml*
        kontaktListe.toFirst();
        
        while (kontaktListe.hasAccess()) {
            Kontakt k = kontaktListe.getContent();
            if (k.getVorname().equals(vorname)) {
                return true;
            }
            kontaktListe.next();
        }
        
        return false;
        //*ml
    }
    
    /**
     * Löscht den aktuellen Kontakt aus der Liste.
     */
    public void aktuellenKontaktLoeschen() {
        /*aufg* 1
        // TODO: Entferne das aktuelle Element der Liste
        *aufg*/
        /*aufg* 2
        // TODO: Entferne das aktuelle Element der Liste
        //kontaktListe.___();
        *aufg*/
        //ml*
        kontaktListe.remove();
        //*ml
    }

       
    /**
     * Fügt einen neuen Kontakt sortiert nach Nachname in die Liste ein.
     * Die Liste wird alphabetisch nach Nachnamen sortiert gehalten.
     * 
     * Die Methode compareTo() der String-Klasse kann verwendet werden, um zwei Strings alphabetisch zu vergleichen.
     * Sie gibt einen Wert kleiner als 0 zurück, wenn der erste String alphabetisch vor dem zweiten String liegt, 
     * 0 wenn sie gleich sind, 
     * und einen Wert größer als 0, wenn der erste String alphabetisch nach dem zweiten String kommt.
     * 
     * 
     * 
     * @param vorname Der Vorname des Kontakts
     * @param nachname Der Nachname des Kontakts
     * @param telNr Die Telefonnummer des Kontakts
     */
    public void kontaktSortiertEinfuegen(String vorname, String nachname, String telNr) {
        /*aufg* 1
        // TODO: Erstelle ein neues Kontakt-Objekt mit den übergebenen Parametern
        // TODO: Setze den Zeiger auf das erste Element
        // TODO: Durchlaufe die Liste und vergleiche die Nachnamen
        // TODO: Wenn der Nachname des aktuellen Kontakts alphabetisch größer ist,
        //       füge den neuen Kontakt VOR dem aktuellen ein (mit insert) und beende die Methode
        //       Um zwei Strings alphabetisch zu vergleichen, nutze die Methode compareTo() der String-Klasse
        // TODO: Gehe zum nächsten Element
        // TODO: Wenn kein passender Platz gefunden wurde, füge den Kontakt am Ende ein (mit append)
        *aufg*/
        /*aufg* 2
        // TODO: Erstelle ein neues Kontakt-Objekt mit den übergebenen Parametern
        // TODO: Setze den Zeiger auf das erste Element
        // TODO: Durchlaufe die Liste und vergleiche die Nachnamen
        // TODO: Wenn der Nachname des aktuellen Kontakts alphabetisch größer ist,
        //       füge den neuen Kontakt VOR dem aktuellen ein (mit insert) und beende die Methode
        // TODO: Gehe zum nächsten Element
        // TODO: Wenn kein passender Platz gefunden wurde, füge den Kontakt am Ende ein (mit append)
        //Kontakt neuerKontakt = new Kontakt(___, ___, ___);
        //kontaktListe.___();
        //
        //while (kontaktListe.___()) {
        //    Kontakt k = kontaktListe.___();
        //    if (k.getNachname().compareTo(___) > 0) {
        //        kontaktListe.___(neuerKontakt);
        //        return;
        //    }
        //    kontaktListe.___();
        //}
        //
        //kontaktListe.___(neuerKontakt);
        *aufg*/
        //ml*
        Kontakt neuerKontakt = new Kontakt(vorname, nachname, telNr);
        kontaktListe.toFirst();
        
        while (kontaktListe.hasAccess()) {
            Kontakt k = kontaktListe.getContent();
            if (k.getNachname().compareTo(nachname) > 0) {
                kontaktListe.insert(neuerKontakt);
                return;
            }
            kontaktListe.next();
        }
        
        kontaktListe.append(neuerKontakt);
        //*ml
    }    
    
    /**
     * Zählt die Anzahl der Kontakte in der Liste.
     * 
     * @return Die Anzahl der Kontakte
     */
    public int anzahlKontakte() {
        /*aufg* 1
        // TODO: Zusatzaufgabe: Erstelle eine Zählvariable und initialisiere sie mit 0
        // TODO: Setze den Zeiger auf das erste Element
        // TODO: Durchlaufe die Liste und erhöhe bei jedem Kontakt den Zähler
        // TODO: Gib die Anzahl zurück
        return 0;
        *aufg*/
        /*aufg* 2
        // TODO: Erstelle eine Zählvariable und initialisiere sie mit 0
        // TODO: Setze den Zeiger auf das erste Element
        // TODO: Durchlaufe die Liste und erhöhe bei jedem Kontakt den Zähler
        // TODO: Gib die Anzahl zurück
        //int anzahl = ___;
        //kontaktListe.___();
        //while (kontaktListe.___()) {
        //    ___++;
        //    kontaktListe.___();
        //}
        return -1; // Rückgabewert anpassen
        *aufg*/
        //ml*
        int anzahl = 0;
        kontaktListe.toFirst();
        while (kontaktListe.hasAccess()) {
            anzahl++;
            kontaktListe.next();
        }
        return anzahl;
        //*ml
    }
}
