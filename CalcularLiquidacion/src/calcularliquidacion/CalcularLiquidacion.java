package calcularliquidacion;

import javax.swing.JOptionPane;

public class CalcularLiquidacion
{
    public static double leerDouble(String mensaje) //Funcion que lee un entero
    {
        return Double.parseDouble(JOptionPane.showInputDialog(mensaje));
    }
    
    public static void imprimirMensaje(String mensaje) //Funcion que imprime un mensaje
    {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public static double calcularPrima(double salario, double dias)
    {
        return (salario*dias)/360;
    }
    
    public static double calcularInteresCesantias(double cesantias, double dias) 
    {
        return (cesantias*0.12*dias)/360;
    }
    
    public static double calcularVacaciones (double salario, double dias)
    {
        return (calcularPrima(salario, dias)/2);
    }
    
    public static double calcularLiquidacion (double prima, double cesantias, double intereses, double vacaciones)
    {
        return (prima+cesantias+intereses+vacaciones);
    }
    
    public static double calcularRetencionFuente(double liquidacion)
    {
        return (liquidacion*0.07);
    }
    
    public static double calcularBonoSolidario(double prima, double cesantias, double vacaciones)
    {
        return (prima+cesantias+vacaciones)*(0.01);
    }
    
    public static double ajustarLiquidacion(double liquidacion)
    {
        double liqAjustada;
        
        liqAjustada=0;
        
        if (liquidacion<3000000)
        {
            liqAjustada=3500000;
        }
        else if (liquidacion>7000000)
        {
            liqAjustada=liquidacion-(liquidacion*0.02);
        }
        else
        {
            liqAjustada=liquidacion;
        }
        return liqAjustada;
    }
    
    public static double ajustarVacaciones(double vacaciones)
    {
        double vacAjustadas;        
        
        vacAjustadas=vacaciones;
        
        if (vacaciones<180)
        {
            vacAjustadas=200000;
        }
        return vacAjustadas;
    }  
    
    public static void main(String[] args)
    {
        double salarioBase, diasLaborados, prima, cesantias, interCesantias, vacaciones, liquidacion, bonoSolidario, retFuente, vacAj, liqAj;
        
        salarioBase=leerDouble("Ingrese el valor del salario basico: ");
        diasLaborados=leerDouble("Ingrese la cantidad de dias laborados: ");
        prima=calcularPrima(salarioBase, diasLaborados);
        cesantias=prima;
        interCesantias=calcularInteresCesantias(cesantias, diasLaborados);
        vacaciones=calcularVacaciones(salarioBase, diasLaborados);
        liquidacion=calcularLiquidacion(prima, cesantias, interCesantias, vacaciones);
        retFuente=calcularRetencionFuente(liquidacion);
        bonoSolidario=calcularBonoSolidario(prima, cesantias, vacaciones);
        
        vacAj=ajustarVacaciones(vacaciones);
        liqAj=ajustarLiquidacion(liquidacion);
        
        imprimirMensaje("El valor de la prima es: "+prima);
        imprimirMensaje("El valor de las cesantias es: "+cesantias);
        imprimirMensaje("Los intereses de las cesantias son: "+interCesantias);
        imprimirMensaje("El valor de las vacaciones son: "+vacAj);
        imprimirMensaje("El valor de la liquidacion es: "+liqAj);
        imprimirMensaje("El valor de la retencion de fuente es: "+retFuente);
        imprimirMensaje("El valor del bono de solidaridad pensional es: "+bonoSolidario);
    }
}