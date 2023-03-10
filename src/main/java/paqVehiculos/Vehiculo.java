package paqVehiculos;

import Assets.Fecha;
import Exceptions.PrecioIncorrecto;
import java.util.Objects;

public class Vehiculo {

    private String modelo;
    private int precio;
    private Fecha fechaCompra;

    public Vehiculo() {
        this.modelo = null;
        this.precio = 0;
        this.fechaCompra = new Fecha();
    }

    public Vehiculo(String modelo, int precio, int dia, int mes, int anio) {
        this.modelo = modelo;
        try {
            validarPrecio(precio);
            this.precio = precio;
        } catch (PrecioIncorrecto e) {
            System.out.println(e.getMessage());
            this.precio = 0;
        }
        this.fechaCompra = new Fecha(dia, mes, anio);

    }

    public Vehiculo(String modelo, int precio, Fecha f) {

        this.modelo = modelo;
        try {
            validarPrecio(precio);
            this.precio = precio;
        } catch (PrecioIncorrecto e) {
            System.out.println(e.getMessage());
            this.precio = 0;
        }
        this.fechaCompra = f;

    }

    public Vehiculo(Vehiculo v) {
        this.modelo = v.modelo;
        this.precio = v.precio;
        this.fechaCompra = v.fechaCompra;

    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        try {
            validarPrecio(precio);
            this.precio = precio;
        } catch (PrecioIncorrecto e) {
            System.out.println(e.getMessage());
        }

    }

    public Fecha getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Fecha fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public void setFechaCompra(int dia, int mes, int anio) {
        fechaCompra.setDia(dia);
        fechaCompra.setMes(mes);
        fechaCompra.setAnio(anio);
    }

    public void setVehiculo(String modelo, int precio, int dia, int mes, int anio) {
        setModelo(modelo);
        setPrecio(precio);
        setFechaCompra(dia, mes, anio);

    }

    public void setVehiculo(String modelo, int precio, Fecha f) {

        this.modelo = modelo;
        this.precio = precio;
        this.fechaCompra = f;

    }

    public void setVehiculo(Vehiculo f) {

        this.modelo = f.getModelo();
        this.precio = f.getPrecio();
        this.fechaCompra = f.getFechaCompra();

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
        final Vehiculo other = (Vehiculo) obj;
        if (this.precio != other.precio) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        return Objects.equals(this.fechaCompra, other.fechaCompra);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.modelo);
        hash = 59 * hash + this.precio;
        hash = 59 * hash + Objects.hashCode(this.fechaCompra);
        return hash;
    }

    @Override
    public String toString() {
        return  "\nModelo:    " + modelo + ", Precio:    " + precio + "€ , Fecha de Compra:    " + fechaCompra +" ";
    }
    
    
     

    public void validarPrecio(int precio) throws PrecioIncorrecto {
        if (!(precio >= 0)) {
            throw new PrecioIncorrecto("El precio insertado no es válido por defecto quedara en 0€");
        }

    }

}
