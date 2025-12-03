
/**
 * Beschreiben Sie hier die Klasse Kampf.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Kampf
{
    
    
    void main(){
        Pokemon pokemon1 = new Pokemon("Pikachu", 80, 23); 
        Pokemon pokemon2 = new Pokemon("Glumanda", 100, 16); 
        
        while(pokemon1.istBesiegt() == false && pokemon2.istBesiegt() == false){
            
            pokemon1.tackle(pokemon2); 
            if(pokemon2.istBesiegt()){
                System.out.println(pokemon2.getName() + " ist besiegt! " + pokemon1.getName() + " hat gewonnen!"); 
                break; 
            }
            
            pokemon2.tackle(pokemon1);

            if (pokemon1.istBesiegt()) {
                System.out.println(pokemon1.getName() + " ist besiegt! " + pokemon2.getName() + " hat gewonnen!");
                break;
            }

            
        }
        
    }
        
}
