
/**
 * Beschreiben Sie hier die Klasse Pokemon.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Pokemon
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
    }

    //Angriffsmethode
    public void tackle(Pokemon gegner){
        
        System.out.println(this.name + " greift " + gegner.getName() + " an!");
        //gegner.lebenspunkte -= this.angriff;
        gegner.verliereLP(this.angriff); 
       
        System.out.println(gegner.getName() + " hat jetzt " + gegner.getLebenspunkte() + " Lebenspunkte.");
    }
    
    //Abfrage, ob Pokemon besiegt oder nicht
    public boolean istBesiegt(){
        return lebenspunkte <= 0; 
    }
    
    public void verliereLP(int angriff){
        
        this.setLebenspunkte(lebenspunkte-angriff);
 
    }
    
    public int setLebenspunkte(int lebenspunkte){
        this.lebenspunkte = lebenspunkte; 
         if (this.getLebenspunkte() < 0) {
            lebenspunkte = 0;  
        }
        return this.lebenspunkte; 
    }
    
    public String getName(){
        return name; 
    }
    
    public int getLebenspunkte(){
        return lebenspunkte; 
    }
    
    public int getAngriff(){
        return angriff; 
    }
}
