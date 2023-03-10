package paqVehiculos;

import Assets.Fecha;
import Exceptions.RevisionesIncorrectas;
import java.util.Arrays;
import java.util.Objects;

public class Moto extends VehiculoConMotor {

    private int kms[] = new int[20];
    private int gastos[] = new int[20];
    private String matricula;
    private String propietario;
    private int numRevisiones;

    public Moto() {
        super();
        this.matricula = null;
        this.propietario = null;
        this.numRevisiones = 0;
    }

    public Moto(int[] kms, int[] gastos, String matricula, String propietario, int numRevisiones, int potencia, String modelo, int precio, int dia, int mes, int anio) {
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

    public Moto(int[] kms, int[] gastos, String matricula, String propietario, int numRevisiones, int potencia, String modelo, int precio, Fecha f) {
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

    public Moto(int[] kms, int[] gastos, String matricula, String propietario, int numRevisiones, int potencia, Vehiculo v) {
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

    public Moto(int[] kms, int[] gastos, String matricula, String propietario, int numRevisiones, VehiculoConMotor v) {
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

    public int[] getKms() {
        return kms;
    }
    public int getKms(int posicion) {
        return kms[posicion];
    }

    public void setKms(int[] kms) {
        this.kms = kms;
    }

    public int[] getGastos() {
        return gastos;
    }
    public int getGastos(int posicion) {
        
        return gastos[posicion];
    }

    public void setGastos(int[] gastos) {
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

    public void setMoto(int[] kms, int[] gastos, String matricula, String propietario, int numRevisiones, int potencia, String modelo, int precio, int dia, int mes, int anio) {
        super.setVehiculoConMotor(potencia, modelo, precio, dia, mes, anio);
        setKms(kms);
        setGastos(gastos);
        setMatricula(matricula);
        setPropietario(propietario);
        setNumRevisiones(numRevisiones);
    }

    public void setMoto(int[] kms, int[] gastos, String matricula, String propietario, int numRevisiones, int potencia, String modelo, int precio, Fecha f) {
        super.setVehiculoConMotor(potencia, modelo, precio, f);
        setKms(kms);
        setGastos(gastos);
        setMatricula(matricula);
        setPropietario(propietario);
        setNumRevisiones(numRevisiones);
    }

    public void setMoto(int[] kms, int[] gastos, String matricula, String propietario, int numRevisiones, int potencia, Vehiculo v) {
        super.setVehiculoConMotor(potencia, v);
        setKms(kms);
        setGastos(gastos);
        setMatricula(matricula);
        setPropietario(propietario);
        setNumRevisiones(numRevisiones);
    }

    public void setMoto(int[] kms, int[] gastos, String matricula, String propietario, int numRevisiones, VehiculoConMotor v) {
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

        for (int i = 0; i < kms.length - 1; i++) {
            int indice = i;
            for (int j = i + 1; j < kms.length; j++) {
                if (kms[j] < kms[indice]) {
                    indice = j;
                }
                int auxkms = kms[i];
                kms[i] = kms[indice];
                kms[indice] = auxkms;
                int auxgastos = gastos[i];
                gastos[i] = gastos[indice];
                gastos[indice] = auxgastos;
            }
        }

    }

    protected int lugarRevisionMasCara() {

        int posicionmascara = 0;

        for (int i = 0; i < gastos.length; i++) {

            if (gastos[i] > gastos[posicionmascara]) {

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

            return kms[posicion];

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }

    }

    protected void tenerRevision(int kms, int gastos) {

        int i = 0;
        if (this.numRevisiones >= 20 ) {

            System.out.println("Superado el limite de revisiones");
        } else {

            while (i < this.kms.length) {

                if (this.kms[i] == 0 && this.gastos[i] == 0) {
                    this.kms[i] = kms;
                    this.gastos[i] = gastos;
                    numRevisiones++;
                    break;

                }

                i++;
            }
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj
    ) {
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
        if (!Arrays.equals(this.kms, other.kms)) {
            return false;
        }
        return Arrays.equals(this.gastos, other.gastos);
    }

  public String mostrarKms(){
      String msg = "";
      if (numRevisiones ==0) {
          msg="Sin Revisiones";
      }
    for (int i = 0; i < kms.length; i++) {
    if (kms[i] > 0) {
       msg =  kms[i] + ", " + msg ;
    }
  }
    return msg;
  }
  public String mostrarGastos(){
      String msg = "";
      if (numRevisiones ==0) {
          msg="Sin Revisiones";
      }
    for (int i = 0; i < gastos.length; i++) {
    if (gastos[i] > 0) {
       msg =  gastos[i] + ", " + msg ;
    }
  }
    return msg;
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
