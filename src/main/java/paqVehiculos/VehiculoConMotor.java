package paqVehiculos;

import Assets.Fecha;
import Exceptions.PotenciaIncorrecta;

public class VehiculoConMotor extends Vehiculo {

    private int potencia;

    public VehiculoConMotor() {
        super();

        this.potencia = 0;

    }

    public VehiculoConMotor(int potencia, String modelo, int precio, int dia, int mes, int anio) {
        super(modelo, precio, dia, mes, anio);
        try {
            validarPotencia(potencia);
            this.potencia = potencia;
        } catch (PotenciaIncorrecta e) {
            System.out.println(e.getMessage());
            this.potencia = 0;
        }
    }

    public VehiculoConMotor(int potencia, String modelo, int precio, Fecha f) {
        super(modelo, precio, f);
        try {
            validarPotencia(potencia);
            this.potencia = potencia;
        } catch (PotenciaIncorrecta e) {
            System.out.println(e.getMessage());
            this.potencia = 0;
        }
    }

    public VehiculoConMotor(int potencia, Vehiculo v) {
        super(v);
        try {
            validarPotencia(potencia);
            this.potencia = potencia;
        } catch (PotenciaIncorrecta e) {
            System.out.println(e.getMessage());
            this.potencia = 0;
        }
    }

    public VehiculoConMotor(VehiculoConMotor v) {
        super(v);
        this.potencia = v.getPotencia();
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        try {
            validarPotencia(potencia);
            this.potencia = potencia;
        } catch (PotenciaIncorrecta e) {
            System.out.println(e.getMessage());
            this.potencia = 0;
        }
    }
    
    public void setVehiculoConMotor(int potencia, String modelo, int precio, int dia, int mes, int anio){
        super.setVehiculo(modelo, precio, dia, mes, anio);
        setPotencia(potencia);
    }
    public void setVehiculoConMotor(int potencia, String modelo, int precio, Fecha f){
        super.setVehiculo(modelo,precio,f);
        setPotencia(potencia);
    }
    public void setVehiculoConMotor(int potencia, Vehiculo v){
        super.setVehiculo(v);
        setPotencia(potencia);
    }
    public void setVehiculoConMotor(VehiculoConMotor v){
        super.setModelo(v.getModelo());
        super.setPrecio(v.getPrecio());
        super.setFechaCompra(v.getFechaCompra());
        
        setPotencia(v.getPotencia());
    }

    @Override
    public String toString() {
        return super.toString() + " potencia:    " + potencia + "kW.";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VehiculoConMotor other = (VehiculoConMotor) obj;
        return this.potencia == other.potencia;
    }

    public void validarPotencia(int precio) throws PotenciaIncorrecta {
        if (!(precio >= 0)) {
            throw new PotenciaIncorrecta("La potencia insertada no es válida por defecto quedara en 0 kW");
        }

    }

}
