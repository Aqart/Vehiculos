package paqVehiculos;

import Assets.Fecha;

import Exceptions.PrecioIncorrecto;
import java.util.Arrays;

public class Principal {

    public static void main(String[] args) {
        
        Fecha f = new Fecha(12,4,2022);
        
        Vehiculo v1 = new Vehiculo("Vespa",20000,f);
        
        VehiculoConMotor vc1 = new VehiculoConMotor(1600,v1);
        
         int[] K = new int[20];
         int[] G = new int[20];
         
         K[0] = 30000;
         K[1] = 15500;
         K[2] = 22000;
         
         G[0] = 13000;
         G[1] = 40000;
         G[2] = 2000;
         
         Moto m1 = new Moto(K,G,"MU-3456-CV","Rogelio",3,vc1);
         
         System.out.println(Arrays.toString(m1.getKms()));
         System.out.println(Arrays.toString(m1.getGastos()));
         
         m1.tenerRevision(2345, 25567);
         
         
         System.out.println("La Revisión más cara de: " + m1.getPropietario() + " es " + m1.getGastos(m1.lugarRevisionMasCara()) + "€ " +" y sus Kilometros: " + m1.getKms(m1.lugarRevisionMasCara())+ "Kms.");
       
         Vehiculo[] vehiculos = {m1,vc1,v1};
         System.out.println("");
         for (int i = 0; i < vehiculos.length; i++) {
            
             if (vehiculos[i] instanceof Moto){
                    System.out.println("\n---------" +(i+1)+"."+" es una Moto ---------");
                 System.out.println(m1);
                 System.out.println("");
             }
             
             if (vehiculos[i] instanceof VehiculoConMotor) {
                 System.out.println("\n---------" +(i+1)+"."+" es un Vehiculo Con Motor---------");
                 System.out.println(vc1);
                 System.out.println("");
             }
             
             if (vehiculos[i] instanceof Vehiculo){
                System.out.println("\n---------" +(i+1)+"."+" es un Vehiculo ---------");
                 System.out.println(v1);
                 System.out.println("");
             }
             
        }
         
         

    }
    

}
