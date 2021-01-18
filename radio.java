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

    public boolean getonOff()
    {
        return onOff;
    }


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

    public boolean getamFm()//devuelve la frecuencia como un boolean
    {
        return frecuencia;
    }

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

    @Override
    public boolean encenderApagar()//metodo para apagar o encender
    {
        setonOff();    
        return getonOff();
    }

    public void setEstacion(double estacion) 
    {
        this.estacion = estacion;
    }

    public double getEstacion() 
    {
        return estacion;
    }

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


    public radio()
    {
        onOff = false;
        estacion = 0.0;
        frecuencia = false ;
        botones =  new Double[]{0.0 , 0.0 , 0.0 , 0.0 , 0.0 , 0.0 , 0.0 , 0.0 , 0.0 , 0.0 , 0.0 , 0.0};
    }

    @Override
    public String guardar(int btn) 
    {
        botones[btn] = getEstacion();
        return Double.toString(botones[btn]);
    }

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