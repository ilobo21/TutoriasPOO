
/**
 * Write a description of class Cliente here.
 *
 * @author Yo
 * @version (a version number or a date)
 */
public class Cliente
{
    private String id;
    private String name;
    private String telefono;
    private String correo;
    private int cantidadCuentas;
    
    public Cliente(String id, String pName, String pTelefono, String correo){
        this.id = id;
        name = pName;
        telefono = pTelefono;
        this.correo = correo;
        cantidadCuentas = 0;
    }
    
    public void crearCuenta(){
        cantidadCuentas++;
    }
    
    public boolean eliminarCuenta(){
        if (verificarCantidadCuentas()){
            cantidadCuentas--;
            return true;
        }
        return false;
    }
    
    private boolean verificarCantidadCuentas(){
        return cantidadCuentas > 0;
    }
    
    public String getName(){
        return name;
    }
    
    public int getCantidadCuentas(){
        return cantidadCuentas;
    }
}