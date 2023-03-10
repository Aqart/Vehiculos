
package Exceptions;


public class PotenciaIncorrecta extends IllegalArgumentException
{
   
    
    public PotenciaIncorrecta() 
    {
        super("La potencia es incorrecta");
    }

    public PotenciaIncorrecta(String ErrMsg)
    {
        super(ErrMsg);
        
    }
    

    
}
