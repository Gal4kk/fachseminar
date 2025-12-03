import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse Pokemon.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Pokemon extends Actor
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private String name; 
    private int lebenspunkte;
    private int angriff; 
    

    /**
     * Konstruktor für Objekte der Klasse Pokemon
     */
    public Pokemon(String name, int lebenspunkte, int angriff)
    {
        // Instanzvariable initialisieren
        this.name = name; 
        this.lebenspunkte = lebenspunkte; 
        this.angriff = angriff; 
        setImage(name+".png");
    }
    /**
     * Act - tut, was auch immer Pokemon tun will. Diese Methode wird aufgerufen, 
     * sobald der 'Act' oder 'Run' Button in der Umgebung angeklickt werden. 
     */
    public void act() 
    {
        // Ergänzen Sie Ihren Quelltext hier...
    }    
}