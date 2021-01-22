/*
Programadores: Diego Perdomo Sagastume y Ana Gabriela Ramírez
Nombre del programa: radio.java (demende de Interface.java)
Lenguaje: Java
Fecha de modificación: 16/01/21
*/


import java.util.Scanner;
public class DriverRadio{
    
    /** 
     * Método ejecutor que permite correr el programa
     * @param args[]
     */
    public static void main(String args[])
    {
        radio r = new radio();
        Scanner read = new Scanner(System.in);
        System.out.println("Bienvenido a la radio");
        boolean flag = true;
        while(flag)
        {
            int op = 0;
            System.out.println("1. Prende el radio\n2. Cambia de AM a FM a AM\n3. Avanzar en el dial de las emisoras. Al llegar al final del dial inicia nuevamente.\n4. Permite guardar una emisora en uno de los 12 botones\n5. Permite seleccionar la emisora puesta en un botón\n6. Apagar el radio\n");

            while(op == 0)
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

            
            

            if (op == 1)
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
            else if (op == 2)
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
            else if (op == 3)
            {
        System.out.println("La estación actual es " + r.avanzar()+"\n");
            }
            else if (op == 4)
            {
                int boton = 0;
                while (boton == 0)
                {
                    System.out.println("Ingrese el boton (1 a 12) en el que desea guardar la estación actual\n");
                    String b = read.nextLine();
                    if(DriverRadio.option(b, 1, 12))
                    {
                        boton = Integer.parseInt(b);
                    }
                    else
                    {
                        System.out.println("No hay tal boton");
                    }
                }
                System.out.println("Se ha guadado la estacion " + r.guardar(boton) + " en el boton "+ boton + "\n");
            }
            else if (op == 5)
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
            else 
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

    
    /** 
     * Metodo para checar si un string es numérico
     * @param s
     * @return boolean
     */
    public static boolean check(String s)
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

    
    /** 
     * metodo para verificar que un num esta en el rango indicado
     * @param min
     * @param max
     * @param x
     * @return boolean
     */
    public static boolean rango(int min, int max, int x)
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
    
    
    
    /** 
     * Método que integra las funciones rango y check para validar una opción numérica de forma eficiente
     * @see check(String s)
     * @see rango(int min, int max, int x)
     * @param e
     * @param i
     * @param j
     * @return boolean
     */
    public static boolean option(String e, int i, int j)
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