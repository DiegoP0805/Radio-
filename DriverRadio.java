/*
Programadores: Diego Perdomo Sagastume y Ana Gabriela Ramírez
Nombre del programa: DriverRadio.java (depende de radio.java)
Lengaje: Java
Fecha de modificación: 17/01/21
*/
import java.util.Scanner;
public class DriverRadio{
    public static void main(String args[])
    {
		//se crean las variables básicas necesarias
        radio r = new radio();
        Scanner read = new Scanner(System.in);
        System.out.println("Bienvenido a la radio");
        boolean flag = true;
        while(flag)//while que mantiene al ususario en el programa 
        {
            int op = 0;
			//se da la bienvenida al ususario
            System.out.println("1. Prende el radio\n2. Cambia de AM a FM a AM\n3. Avanzar en el dial de las emisoras. Al llegar al final del dial inicia nuevamente.\n4. Permite guardar una emisora en uno de los 12 botones\n5. Permite seleccionar la emisora puesta en un botón\n6. Apagar el radio\n");

            while(op == 0)//no deja que slga del loop hasta que el ususario seleccione una opción válida
            {
                System.out.println("\nEscoja el número de una de las opciones");
                String op2 = read.nextLine();
                if(DriverRadio.option(op2, 1, 6))
                {
                    op = Integer.parseInt(op2);
                }
                else
                {
                    System.out.println("Opcion no valida");
                }
            }

            
            

            if (op == 1)//si selecciona 1 apagará o encenderá eñ radio
            {
                if(r.encenderApagar())
                {
                    System.out.println("Radio encendida\n");
                }
                else
                {
                    System.out.println("Radio apagada\n");
                }
            }
            else if (op == 2)//si selecciona 2 cambiará de Fm a Am o viceversa
            {
                if(r.amFm())
                {
                    System.out.println("Fm\n");
                }
                else
                {
                    System.out.println("Am\n");
                }
            }
            else if (op == 3)//si selecciona 3 avanza en la frecuencia que esté habilitada
            {
        System.out.println("La estación actual es " + r.avanzar()+"\n");
            }
            else if (op == 4)//si lececciona 4 podrá guardar una estación en alguno de los botones
            {
                int boton = 0;
                while (boton == 0)
                {
                    System.out.println("Ingrese el boton (1 a 12) en el que desea guardar la estación actual\n");
                    String b = read.nextLine();
                    if(DriverRadio.option(b, 1, 12))//si inegresa un botón válido
                    {
                        boton = Integer.parseInt(b);
                    }
                    else//si no ingresa un botón válido
                    {
                        System.out.println("No hay tal boton");
                    }
                }
                System.out.println("Se ha guadado la estacion " + r.guardar(boton) + " en el boton "+ boton + "\n");
            }
            else if (op == 5)//si seleciona 5 podrá sintonizar la estación guardada en el botón a seleccionar
            {
                int boton = 0;
                while (boton == 0)
                {
                    System.out.println("Ingrese el boton (1 a 12) que desea sintonizar\n");
                    String b = read.nextLine();
                    if(DriverRadio.option(b, 1, 12))
                    {
                        boton = Integer.parseInt(b);
                    }
                    else
                    {
                        System.out.println("No hay tal boton\n");
                    }
                }
                System.out.println(r.seleccionar(boton)+"\n");
            }
            else //finalmente se apaga la radio al presionar 6
            {
                if(r.encenderApagar())
                {
                    System.out.println("Radio encendida\n");
                }
                else
                {
                    System.out.println("Radio apagada\n");
                }
            }
        }
    }

    public static boolean check(String s)//Metodo para checar si un string es numérico
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

    public static boolean rango(int min, int max, int x)//metodo para verificar que un num esta en rango
    {
        if (x >= min && x <= max)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    public static boolean option(String e, int i, int j)//clase validadora
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
}