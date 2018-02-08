package proyecto1agenda;

import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;

public class AplicacionAgenda {
  
    public static void main(String[] args) {
        
        Calendar fecha;
        Scanner teclado = new Scanner (System.in);
        
        int opcion;
        Agenda agenda = null;
        Pagina pagina = null;
        Pagina actual = new Pagina ();
        Cita cita;
        int hora, minutos, segundos, dia, mes, anyo;
        String texto, titulo;
        
        
        
        /*  EJEMPLO DE CALENDAR
        Calendar ahoraCal = Calendar.getInstance();// extraer la fecha getInstance
        System.out.println(ahoraCal.getTime());
        System.out.println("fecha:" + ahoraCal);
        System.out.println(ahoraCal.getTime().getYear() + + ahoraCal.getTime().getMonth());
      
        System.out.println("ANYO: "+ahoraCal.get(Calendar.YEAR));
        System.out.println("MES: "+ahoraCal.get(Calendar.MONTH));
        System.out.println("DIA: "+ahoraCal.get(Calendar.DATE));
        System.out.println("HORA: "+ahoraCal.get(Calendar.HOUR));
        if (ahoraCal.get(Calendar.MONTH) == Calendar.JUNE){
                System.out.println("ES JUNIO");
        }   else{
                System.out.println("NO ES JUNIO");
            }
        
        Date fecha = new Date();
        System.out.println("fecha" + fecha);
        int opcion;
        */
            System.out.println("Introduce en año de la nueva agenda:");
                anyo = teclado.nextInt();
                
                agenda = new Agenda (anyo);
                
            System.out.println("\n\n" + "*********CITA" + agenda.getAnyo() + "*********");
        do {
                mostrarMenu();
                
                System.out.println("Elige una opción");
                opcion = teclado.nextInt();
                 
                switch (opcion){
                    case 1:
                        //añadir los metodos para validar que los dias y el mes son correctos
                        System.out.println("Introduce el dia:");
                        dia = teclado.nextInt();
                        
                        System.out.println("Introduce mes:");
                        mes = teclado.nextInt();
                        
                        actual = agenda.buscarPagina (dia, mes);
                        //agenda.abierta = agenda.buscarPagina(dia, mes);
                        System.out.println("La pagina seleccionada" + actual.getDia()+ "dia del mes" + actual.getMes());
                        break;
                        
                    case 2:
                        //falta introducir los metodos de validacion de la hora y los minutos
                        System.out.println("Introduce la hora:");
                        hora = teclado.nextInt();
                        
                        System.out.println("Introduce los minutos");
                        minutos = teclado.nextInt();
                        
                        System.out.println("Introduce Titulo:");
                        titulo = teclado.nextLine();
                       
                        System.out.println("Introduce Texto:");
                        texto = teclado.nextLine();
                        
                        teclado.nextLine();//limpiar buffer
                        cita = new Cita (hora, minutos, titulo, texto);
                        actual.añadirCita(cita);
                        actual.leerPagina();
                        
                        break;
                        
                    case 3:
                        break;
                        
                    case 4:
                        break;
                        
                    default:
                        System.out.println("Has elegido una opción ERRONEA");
                        break;                
                }// llave switch
        }while (opcion != 4);
        
    }//llave clase
    
    //metodos
    
    public static void mostrarMenu(){
        System.out.println("1.-Añadir cita");
        System.out.println("2.- Borrar cita");
        System.out.println("3.- Buscar cita");
        System.out.println("4.- Modificar el texto de una cita");
        System.out.println("5.- Salir");
    }
}//llave clase aplicacion agenda