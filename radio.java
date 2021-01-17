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

    public String getfrecuencia()//devuelve la frecuencia como un string para imprimir
    {
        if(frecuencia) 
        {
            return "Frecuencia Am";
        }
        else
        {
            return "Frecuencia Fm";
        }
    }

    public double avanzar(){//metodo para avanzar entre emisoras
		if(frecuencia){
			if(estacion==107.9){
				return 87.9;
			}else{
				return estacion+0.2;
			}
		}else{
			if(estacion==1610){
				return 530;
			}else{
				return estacion+10;
			}
		}
	}

    public radio()
    {
        onOff = false;
        estacion = 0;
        frecuencia = false;
        botones =  new Double[]{0.0 , 0.0 , 0.0 , 0.0 , 0.0 , 0.0 , 0.0 , 0.0 , 0.0 , 0.0 , 0.0 , 0.0};
    }


    public boolean check(String s)//Método para checar si un string es numérico
    {
        boolean numeric = true;
        try 
        {
            int n = Integer.parseInt(s);
        } 
        catch (NumberFormatException e) 
        {
            numeric = false;
        }

        if(numeric)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean rango(int min, int max, int x)//metodo para verificar que un num está en rango
    {
        if (x > min && x <= max)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    public boolean option(String e, int i, int j)//clase validadora
    {
        if (check(e))
        {
            int n = Integer.parseInt(e);
            if(rango(i, j, n))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false; 
        }
    }




    public static void main(String[] args) 
    {
        radio r = new radio();
        System.out.println(r.botones.length);
    }
}