/**
 * Interfaz con el fin de crear parámetros comunes para los estudiantes 
 * @since 14/01/2021
 */

public interface Interface 
{
    /** 
     * Este método pretende servir para cmabiar el estado de apagado o encendido de la radio
     * @return boolean
     */
    public boolean encenderApagar();


    /** 
     * Este método tiene como función cambiar la frecuencia de la radio (AM a Fm y viceversa)
     * @return boolean
     */
    public boolean amFm();

    
    /** 
     * Este método sirve para guardar una estación en alguno de los botones
     * @param btn
     * @return String
     */
    public String guardar(int btn);
    
    
    /** 
     * Método que permite seleccionar uno de los botones y sintonizar la estación guardada en este
     * @param btn
     * @return String
     */
    public String seleccionar(int btn);


    /** 
     * Este método permite avanzar en las diferentes estaciones de las frecuencias
     * @return double
     */
    public double avanzar();
}
