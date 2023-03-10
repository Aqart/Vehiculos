
package Exceptions;




public class PrecioIncorrecto extends IllegalArgumentException
{
   

    public PrecioIncorrecto() {
        super("El precio es incorrecto");
    }
    
   
    public PrecioIncorrecto(String ErrMsg) {
        super(ErrMsg);
    }
    
    
    
    
    
}
