
/**
 * Write a description of class Cuenta here.
 * 
 * @author Yo
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import java.time.LocalDateTime;



public class Cuenta
{
    private int numeroCuenta;
    private String cuentaIban = "CR";
    private String idDuenho;
    private double saldoCuenta;
    private int pin;
    private ArrayList<ArrayList<String>> bitacoraTransacciones;
    private static int cantidadCuentas;
    
    //no tiene que ver con el ejercicio
    
    
    public Cuenta(String idDuenho, int pin){
        this.idDuenho = idDuenho;
        this.pin = pin;
        cantidadCuentas++;
        numeroCuenta = cantidadCuentas;
        cuentaIban += numeroCuenta;
        saldoCuenta = 0;
        bitacoraTransacciones = new ArrayList<>();
    }
    
    public Cuenta(String idDuenho, int pin, double montoInicial){
        this(idDuenho, pin);
        saldoCuenta = montoInicial;
    }
    
    private boolean verificarPin(int pin){
        return this.pin == pin;
        //if(this.pin == pin){ return true;} return false;
    }
    
    private boolean verificarSaldo(double monto){
        return saldoCuenta >= monto;
    }
    
    private void agregarTransaccion(String accion, double monto, LocalDateTime fecha, String estado){
        ArrayList<String> transaccion;
        transaccion = new ArrayList<>();
        transaccion.add(String.valueOf(fecha));
        transaccion.add(String.valueOf(monto));
        transaccion.add(accion);
        transaccion.add(estado);
        bitacoraTransacciones.add(transaccion);
    }
    
    public int retirar(double monto, int pin){
        String estado;
        if (!verificarPin(pin)){
            estado = "Denegada";
            agregarTransaccion("Retiro", monto, LocalDateTime.now(), estado);
            return -1;
        }
        if(!verificarSaldo(monto)){
            estado = "Denegada";
            agregarTransaccion("Retiro", monto, LocalDateTime.now(), estado);
            return -2;
        }
        estado = "Aprobada";
        agregarTransaccion("Retiro", monto, LocalDateTime.now(), estado);
        saldoCuenta -= monto;
        return 1;
    }
    
    public boolean depositar(double monto, int pin){
        String estado;
        if (!verificarPin(pin)){
            estado = "Denegada";
            agregarTransaccion("Retiro", monto, LocalDateTime.now(), estado);
            return false;
        }
        estado = "Aprobada";
        agregarTransaccion("Retiro", monto, LocalDateTime.now(), estado);
        saldoCuenta += monto;
        return true;
    }
    
    public boolean cambiarPin(int pin, int pinNuevo){
        if(!verificarPin(pin)){
            return false;
        }
        this.cambiarPin(pinNuevo);
        return true;
    }
    
    public void cambiarPin(int pinNuevo){
        pin = pinNuevo;
        alertPinChange();
    }
    
    public ArrayList<ArrayList<String>> getBitacora(){
        return bitacoraTransacciones;
    }
    
    public double getSaldo(){
        return saldoCuenta;
    }
    
    public static int getCantidadCuentas(){
        return cantidadCuentas;
    }
    
    public int getNumeroCuenta(){
        return numeroCuenta;
    }
    
    private void alertPinChange(){
        String mensaje;
        mensaje = "Hola\nTu pin ha cambiado";
        EmailSender.sendEmail("Tu Pin Ha Cambiado", idDuenho, mensaje);
    }
    
    
    
    
}