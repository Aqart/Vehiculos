package paqVehiculos;

import Assets.Fecha;
import Exceptions.RevisionesIncorrectas;
import java.util.*;


public class Moto extends VehiculoConMotor {

    private ArrayList<Integer> kms = new ArrayList(20);
    private ArrayList<Integer> gastos = new ArrayList(20);
    private String matricula;
    private String propietario;
    private int numRevisiones;

    public Moto() {
        super();
        this.matricula = null;
        this.propietario = null;
        this.numRevisiones = 0;
    }

    public Moto(ArrayList kms, ArrayList gastos, String matricula, String propietario, int numRevisiones, int potencia, String modelo, int precio, int dia, int mes, int anio) {
        super(potencia, modelo, precio, dia, mes, anio);
        this.matricula = matricula;
        this.propietario = propietario;
        try {
            validarRevisiones(numRevisiones);
            this.numRevisiones = numRevisiones;
        } catch (RevisionesIncorrectas e) {
            System.out.println(e.getMessage());
            this.numRevisiones = 0;
        }
        this.kms = kms;
        this.gastos = gastos;
    }

    public Moto(ArrayList kms, ArrayList gastos, String matricula, String propietario, int numRevisiones, int potencia, String modelo, int precio, Fecha f) {
        super(potencia, modelo, precio, f);
        this.matricula = matricula;
        this.propietario = propietario;
        try {
            validarRevisiones(numRevisiones);
            this.numRevisiones = numRevisiones;
        } catch (RevisionesIncorrectas e) {
            System.out.println(e.getMessage());
            this.numRevisiones = 0;
        }
    }

    public Moto(ArrayList kms, ArrayList gastos, String matricula, String propietario, int numRevisiones, int potencia, Vehiculo v) {
        super(potencia, v);
        this.matricula = matricula;
        this.propietario = propietario;
        try {
            validarRevisiones(numRevisiones);
            this.numRevisiones = numRevisiones;
        } catch (RevisionesIncorrectas e) {
            System.out.println(e.getMessage());
            this.numRevisiones = 0;
        }
        this.kms = kms;
        this.gastos = gastos;
    }

    public Moto(ArrayList kms, ArrayList gastos, String matricula, String propietario, int numRevisiones, VehiculoConMotor v) {
        super(v);
        this.matricula = matricula;
        this.propietario = propietario;
        try {
            validarRevisiones(numRevisiones);
            this.numRevisiones = numRevisiones;
        } catch (RevisionesIncorrectas e) {
            System.out.println(e.getMessage());
            this.numRevisiones = 0;
        }
        this.kms = kms;
        this.gastos = gastos;
    }

    public Moto(Moto m) {
        super.setVehiculoConMotor(m);
        this.matricula = m.getMatricula();
        this.propietario = m.getPropietario();
        this.numRevisiones = m.getNumRevisiones();
        this.kms = m.getKms();
        this.gastos = m.getGastos();

    }

    public ArrayList getKms() {
        return kms;
    }

    public void setKms(ArrayList kms) {
        this.kms = kms;
    }

    public ArrayList getGastos() {
        return gastos;
    }

    public void setGastos(ArrayList gastos) {
        this.gastos = gastos;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public int getNumRevisiones() {
        return numRevisiones;
    }

    public void setNumRevisiones(int numRevisiones) {
        try {
            validarRevisiones(numRevisiones);
            this.numRevisiones = numRevisiones;
        } catch (RevisionesIncorrectas e) {
            System.out.println(e.getMessage());
            this.numRevisiones = 0;
        }
    }

    public void setMoto(ArrayList kms, ArrayList gastos, String matricula, String propietario, int numRevisiones, int potencia, String modelo, int precio, int dia, int mes, int anio) {
        super.setVehiculoConMotor(potencia, modelo, precio, dia, mes, anio);
        setKms(kms);
        setGastos(gastos);
        setMatricula(matricula);
        setPropietario(propietario);
        setNumRevisiones(numRevisiones);
    }

    public void setMoto(ArrayList kms, ArrayList gastos, String matricula, String propietario, int numRevisiones, int potencia, String modelo, int precio, Fecha f) {
        super.setVehiculoConMotor(potencia, modelo, precio, f);
        setKms(kms);
        setGastos(gastos);
        setMatricula(matricula);
        setPropietario(propietario);
        setNumRevisiones(numRevisiones);
    }

    public void setMoto(ArrayList kms, ArrayList gastos, String matricula, String propietario, int numRevisiones, int potencia, Vehiculo v) {
        super.setVehiculoConMotor(potencia, v);
        setKms(kms);
        setGastos(gastos);
        setMatricula(matricula);
        setPropietario(propietario);
        setNumRevisiones(numRevisiones);
    }

    public void setMoto(ArrayList kms, ArrayList gastos, String matricula, String propietario, int numRevisiones, VehiculoConMotor v) {
        super.setVehiculoConMotor(v);
        setKms(kms);
        setGastos(gastos);
        setMatricula(matricula);
        setPropietario(propietario);
        setNumRevisiones(numRevisiones);
    }

    public void setMoto(Moto m) {
        super.setVehiculoConMotor(m);
        setKms(m.getKms());
        setGastos(m.getGastos());
        setMatricula(m.getMatricula());
        setPropietario(m.getPropietario());
        setNumRevisiones(m.getNumRevisiones());
    }

    protected void ordenKms() {

        for (int i = 0; i < kms.size() - 1; i++) {
            int indice = i;
            for (int j = i + 1; j < kms.size(); j++) {
                if (kms.get(j)< kms.get(indice)) {
                    indice = j;
                }
                int auxkms = kms.get(i);
                kms.set(i, indice);
                kms.set(indice, auxkms);
                int auxgastos = gastos.get(i);
                gastos.set(i, indice);
                gastos.set(indice, auxgastos);
            }
        }

    }

    protected int lugarRevisionMasCara() {

        int posicionmascara = 0;

        for (int i = 0; i < gastos.size(); i++) {

            if (gastos.get(i) > gastos.get(posicionmascara)){

                posicionmascara = i;
            }
        }

        return posicionmascara;
    }

    protected int posicionRevision(int posicion) {
        try {
            if (!(numRevisiones > 0)) {
                throw new IllegalArgumentException("Debe de haber al menos 1 revisión");
            }

            return kms.indexOf(posicion);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return kms.indexOf(posicion);
        }

    }

    protected void tenerRevision(int kms, int gastos) {

        if (this.numRevisiones >= 20 ) {

            System.out.println("Superado el limite de revisiones");
        } else {
            this.kms.add(kms);
            this.gastos.add(gastos);
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Moto other = (Moto) obj;
        if (this.numRevisiones != other.numRevisiones) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.propietario, other.propietario)) {
            return false;
        }
        if (!Objects.equals(this.kms, other.kms)) {
            return false;
        }
        return Objects.equals(this.gastos, other.gastos);
    }

  public String mostrarKms(){
     return kms.toString();
  }
  public String mostrarGastos(){
    
    return gastos.toString();
  }
 

    
    @Override
    public String toString() {
        return "**************La Moto de " + propietario + "**************"
                + "\nMatricula:   " + matricula
                + "\nKm:  " + mostrarKms() + " y gastos " + mostrarGastos()
                + "Nº Revisiones Totales:  " + numRevisiones
                + super.toString()
                + "\n**********************************************\n";
                
    }

    public void validarRevisiones(int numrevisiones) throws RevisionesIncorrectas {
        if (!(numrevisiones >= 0)) {
            throw new RevisionesIncorrectas("El Nº de Revisiones insertado no es válido por defecto quedara en 0");
        }

    }

}
