
/**
 * Write a description of class AplGranBanco here.
 *
 * @author Yo
 * @version (a version number or a date)
 */

import java.util.ArrayList;

public class AplGranBanco
{
    public void hagaA(){
        System.out.println("Estoy Haciendo A...");
    }
    public static void main(String[] args){
        Cuenta cta1, cta2, cta3;
        
        cta1 = new Cuenta("444", 1234);
        cta2 = new Cuenta("666", 4321,1200);
        
        System.out.println(cta1.getSaldo()); //0.0
        System.out.println(cta2.getSaldo()); //1200
                            //condicion ? "Sí" : "No"
        cta1.cambiarPin(6789); //"Pin establecido" : "Error"
        System.out.println(cta2.cambiarPin(6789, 1234) ? "Pin establecido" : "Error"); //"Pin establecido" : "Error"
        
        
        
    }
}