import java.util.ArrayList;

/*
Programadores: Diego Perdomo Sagastume y Ana Gabriela Ramírez
Nombre del programa: radio.java (depende de Interface.java)
Lengaje: Java
Fecha de modificación: 16/01/21
*/
public class radio implements Interface
{
	//se instancian las variables a utilizar
    public boolean onOff;
    public double estacion;
    public boolean frecuencia;//am o fm
    public Double[] botones;

    
    /**
     * Setter de la variable onOff
     */
    public void setonOff()//metodo para encender y apagar la radio
    {
        if(onOff)
        {
            onOff = false;
        }
        else
        {
            onOff = true;
        }
    }

    
    /** 
     * Getter de la variable onOff
     * @return boolean
     */
    public boolean getonOff()
    {
        return onOff;
    }


    /**
     * Setter de la variable frecuencia
     */
    public void setfrecuencia()//metodo para cambiar de precuencia
    {
        if(frecuencia)
        {
            frecuencia = false;
        }
        else
        {
            frecuencia = true;
        }
    }

    
    /** 
     * Getter de la variable de la frecuencia
     * @return boolean
     */
    public boolean getamFm()//devuelve la frecuencia como un boolean
    {
        return frecuencia;
    }

    
    /** 
     * Este método tiene como función cambiar la frecuencia de la radio (AM a Fm y viceversa)
     * @return boolean
     * @see getamFm()
     * @see setEstacion()
     * @see setfrecuencia()
     */
    @Override
    public boolean amFm()//metodo para cambiar la frecuencia
    {
        setfrecuencia();
        //avanzar();//arregla esto
        if(getamFm())
        {
            setEstacion(87.9);
        }
        else
        {
            setEstacion(530);
        }
        return getamFm();
    }

    
    /** 
     * Este método pretende servir para cmabiar el estado de apagado o encendido de la radio
     * @return boolean
     * @see setonOff()
     */
    @Override
    public boolean encenderApagar()
    {
        setonOff();    
        return getonOff();
    }

    
    /** 
     * @param estacion
     */
    public void setEstacion(double estacion) 
    {
        this.estacion = estacion;
    }

    
    /** 
     * Getter de la estación
     * @return double
     */
    public double getEstacion() 
    {
        return estacion;
    }

    
    /** 
     * Este método permite avanzar en las diferentes estaciones de las frecuencias
     * @return double
     * @see getamFm()
     * @see setEstacion()
     * @see getEstacion()
     */
    @Override
    public double avanzar()//metodo para avanzar entre emisoras
    {
        if(getamFm()){
			if(getEstacion()==107.9 || getEstacion() == 0.0){
                setEstacion(87.9);
				return getEstacion();
			}else{
                setEstacion(getEstacion() + 0.2);
                return getEstacion();
			}
		}else{
			if(getEstacion() ==1610.0 || getEstacion() == 0.0){
				setEstacion(530.0);
				return getEstacion();
			}else{
				setEstacion(getEstacion() + 10.0);
                return getEstacion();
			}
		}
    }


    /**
     * Este método sirve como el constructor 
     */
    public radio()
    {
        onOff = false;
        estacion = 0.0;
        frecuencia = false ;
        botones =  new Double[]{0.0 , 0.0 , 0.0 , 0.0 , 0.0 , 0.0 , 0.0 , 0.0 , 0.0 , 0.0 , 0.0 , 0.0};
    }

    
    /** 
     * Este método sirve para guardar una estación en alguno de los botones
     * @param btn
     * @return String
     * @see getEstacion()
     */
    @Override
    public String guardar(int btn) 
    {
        botones[btn] = getEstacion();
        return Double.toString(botones[btn]);
    }

    
    /** 
     * Método que permite seleccionar uno de los botones y sintonizar la estación guardada en este
     * @param btn
     * @return String
     * @see getamFm()
     * @see setEstacion()
     * @see setfrecuencia()
     * @see getEstacion()
     */
    @Override
    public String seleccionar(int btn) 
    {
        if(botones[btn] >= 87.9 && botones[btn] <= 107.9)
        {
            if(getamFm())
            {
                setEstacion(botones[btn]);
                return Double.toString(getEstacion());
            }
            else
            {
                setfrecuencia();
                setEstacion(botones[btn]);
                return Double.toString(getEstacion());  
            }
            
        }
        else if(botones[btn] >= 530.0 && botones[btn] <= 1610.0)
        {
            if(getamFm())
            {
                setfrecuencia();
                setEstacion(botones[btn]);
                return Double.toString(getEstacion());
            }
            else
            {
                setEstacion(botones[btn]);
                return Double.toString(getEstacion());
            }
        }
        else
        {
            return "No hay estacion guardada en este boton";
        }
    }

}