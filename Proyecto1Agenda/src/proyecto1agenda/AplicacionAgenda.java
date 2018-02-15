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
        Cita citas, citas1;
        int hora, minutos, segundos, dia, mes, anyo;
        String texto, titulo, cita; 
        
        
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
            System.out.println("Introduce el año de la nueva agenda:");
                anyo = teclado.nextInt();
                
                agenda = new Agenda (anyo);
                
            System.out.println("\n" + "*********CITA" + " " + agenda.getAnyo() + "********* \n");//la \n significa intro, pasa a otra linea
            
        do {
                mostrarMenu();
                
                System.out.println("Elige una opción");
                opcion = teclado.nextInt();
                 
                switch (opcion){
                    case 1:
                        //añadir los metodos para validar que los dias y el mes son correctos
                       do{
                           
                        System.out.println("Introduce el dia:");
                        dia = teclado.nextInt();
                       
                        System.out.println("Introduce mes:");
                        mes = teclado.nextInt();
                        
                        //actual = agenda.buscarPagina (dia, mes); pero la tendriamos q declarar en agenda (Pagina actual)
                        agenda.abierta = agenda.buscarPagina(dia, mes);// es lo mismo que lo de arriba 
                        
                        //VAMOS A VALIDAR QUE EL DIA Y EL MES SON CORRECTOS ESTAN COMPRENDIDOS ENTRE LOS DIAS 1 Y 31 Y LOS MESES 1 Y 12
                        if (comprobarFecha(dia,mes) == true){
                            System.out.println("*****************************************");
                            System.out.println("EL DIA Y EL MES INTRODUCIDO ES CORRECTO");
                            System.out.println("*****************************************");
                            
                            System.out.println("************************************************");
                            System.out.println("La página seleccionada es el dia " + agenda.abierta.getDia() + " del mes " + agenda.abierta.getMes());
                            System.out.println("************************************************");
                        } else {
                            System.out.println("*****************************************");
                            System.out.println("EL DIA Y EL MES INTRODUCIDO ES INCORRECTO");
                            System.out.println("*****************************************");
                          } 
                       } while (!comprobarFecha (dia,mes));
                        break;
                        
                    case 2:
                        //falta introducir los metodos de validacion de la hora y los minutos
                        do {
                            System.out.println("Introduce la hora:");
                            hora = teclado.nextInt();
                        
                            System.out.println("Introduce los minutos");
                            minutos = teclado.nextInt();
                        
                            //COMPROBAMOS QUE LA HORA Y LOS MINUTOS SON CORRECTOS
                            if (comprobarHora(hora, minutos)) {
                                System.out.println("La hora es correcta");
                            } else {
                                System.out.println("La hora es incorrecta");
                              }
                        } while (!comprobarHora(hora,minutos));
                        
                            teclado.nextLine();//limpiar buffer
                            System.out.println("Introduce Titulo:");
                            titulo = teclado.nextLine();
                       
                            System.out.println("Introduce Texto:");
                            texto = teclado.nextLine();
                        
                            citas = new Cita (hora, minutos, titulo, texto);
                        
                            if (agenda.abierta.comprobarCita(hora, minutos)) {
                                 System.out.println("La cita no se puede crear porque ya existe");
                            } else {
                                agenda.abierta.añadirCita(citas);
                                System.out.println("************************************");
                                System.out.println("La cita se ha registrado con éxito: ");
                                cita = citas.leerCita();
                                System.out.println(cita);
                                System.out.println("************************************"); 
                               }
                        break;
                        
                    case 3:
                        do {
                            System.out.println("Introduce el dia de la cita a borrar");
                            dia = teclado.nextInt();

                            System.out.println("Introduce el mes de la cita a borrar");
                            mes = teclado.nextInt();

                            //COMPROBAR QUE EL DIA Y EL MES SEAN CORRECTOS
                            if (comprobarFecha(dia, mes)) {
                                System.out.println("Fecha correcta");
                                agenda.abierta = agenda.buscarPagina(dia, mes);
                                System.out.println("La página seleccionada es el dia " + agenda.abierta.getDia() + " del mes " + agenda.abierta.getMes());
                            } else {
                                System.out.println("Fecha incorrecta");
                              }
                        } while (!comprobarFecha(dia, mes));

                        do {
                            System.out.println("Introduce hora de la cita a borrar");
                            hora = teclado.nextInt();

                            System.out.println("Introduce minutos de la cita a borrar");
                            minutos = teclado.nextInt();

                            //COMPROBAR QUE LA HORA Y LOS MINUTOS SON CORRECTOS
                            if (comprobarHora(hora, minutos)) {
                                System.out.println("La hora es correcta");
                            } else {
                                System.out.println("La hora es incorrecta");
                              }
                        } while (!comprobarHora(hora, minutos));

                        citas1 = agenda.abierta.buscarCita(hora, minutos);
                        if (citas1 == null) {
                            System.out.println("La cita no existe");
                        } else {
                            agenda.abierta.borrarCita(citas1);
                            System.out.println("Cita encontrada");
                            System.out.println("Cita borrada con éxito");
                            System.out.println("*********************************");
                            System.out.println("Las citas restantes del día son: ");
                            agenda.abierta.leerPagina();
                            System.out.println("*********************************");
                          }
                        break;
                        
                    case 4:
                        do {
                        System.out.println("Introduce dia");
                        dia = teclado.nextInt();

                        System.out.println("Introduce mes");
                        mes = teclado.nextInt();

                        //COMPROBAMOS DIA Y MES
                        if (comprobarFecha(dia, mes)) {
                            System.out.println("Fecha correcta");

                            agenda.abierta = agenda.buscarPagina(dia, mes);
                            System.out.println("La página seleccionada es el dia " + agenda.abierta.getDia() + " del mes " + agenda.abierta.getMes());
                        } else {

                            System.out.println("Fecha incorrecta");
                        }
                    } while (!comprobarFecha(dia, mes));

                    do {
                        System.out.println("Introduce hora");
                        hora = teclado.nextInt();

                        System.out.println("Introduce minutos");
                        minutos = teclado.nextInt();

                        //COMPROBAMOS HORA Y MINUTOS
                        if (comprobarHora(hora, minutos)) {
                            System.out.println("La hora es correcta");
                        } else {
                            System.out.println("La hora es incorrecta");
                        }
                    } while (!comprobarHora(hora, minutos));

                    citas1 = agenda.abierta.buscarCita(hora, minutos);
                    if (citas1 == null) {
                        System.out.println("La cita no existe");
                    } else {
                        System.out.println("La cita que buscas es: ");
                        System.out.println("****************************");
                        cita = citas1.leerCita();
                        System.out.println(cita);
                        System.out.println("****************************");
                    }
                        break;
                        
                    case 5:
                        do {
                        System.out.println("Introduce dia");
                        dia = teclado.nextInt();

                        System.out.println("Introduce mes");
                        mes = teclado.nextInt();

                        //COMPROBAMOS DIA Y MES
                        if (comprobarFecha(dia, mes)) {
                            System.out.println("Fecha correcta");

                            agenda.abierta = agenda.buscarPagina(dia, mes);
                            System.out.println("La página seleccionada es el dia " + agenda.abierta.getDia() + " del mes " + agenda.abierta.getMes());
                        } else {

                            System.out.println("Fecha incorrecta");
                        }
                    } while (!comprobarFecha(dia, mes));

                    do {
                        System.out.println("Introduce hora:");
                        hora = teclado.nextInt();

                        System.out.println("Introduce minutos:");
                        minutos = teclado.nextInt();

                        //COMPROBAMOS HORA Y MINUTOS
                        if (comprobarHora(hora, minutos)) {
                            System.out.println("La hora es correcta");
                        } else {
                            System.out.println("La hora es incorrecta");
                        }
                    } while (!comprobarHora(hora, minutos));

                    citas1 = agenda.abierta.buscarCita(hora, minutos);
                    
                    if (citas1 == null) {
                        System.out.println("La cita no existe");
                    } else {
                        System.out.println("Cita encontrada");
                        cita= citas1.leerCita();
                        System.out.println("****************************");
                        System.out.println(cita);
                        System.out.println("****************************");
                        teclado.nextLine();
                        System.out.println("Introduce el nuevo texto:");
                        texto = teclado.nextLine();
                        agenda.abierta.modificarTexto(citas1, texto);
                        System.out.println("****************************");
                        System.out.println("Texto modificado con éxito:");
                        cita= citas1.leerCita();
                        System.out.println(cita);
                        System.out.println("****************************");
                    }
                        break;
                    
                    case 6:
                          System.out.println("******************");
                          agenda.abierta.leerPagina();
                          System.out.println("******************");
                          break;
                        
                    case 7:
                        System.out.println("Salir");
                        break;
                        
                    default:
                        System.out.println("Has elegido una opción ERRONEA");
                        break;                
                }// llave switch
        }while (opcion != 7);
        
    }//llave main
    
    //metodos
    
    public static void mostrarMenu(){
        System.out.println("1.- Seleccionar el dia y mes");
        System.out.println("2.- Añadir cita");
        System.out.println("3.- Borrar cita");
        System.out.println("4.- Buscar cita");
        System.out.println("5.- Modificar el texto de una cita");
        System.out.println("6.- Listar todas las citas");
        System.out.println("7.- Salir");
    }
    
    public static boolean comprobarFecha (int dia, int mes) {

        if (mes >= 1 && mes <= 12) {
            switch (mes) {
                case 1:
                    if (dia >= 1 && dia <= 31) {
                        return true;
                    }
                    break;
                case 2:
                    if (dia >= 1 && dia <= 30) {
                        return true;
                    }
                    break;
                case 3:
                    if (dia >= 1 && dia <= 31) {
                        return true;
                    }
                    break;
                case 4:
                    if (dia >= 1 && dia <= 30) {
                        return true;
                    }
                    break;
                case 5:
                    if (dia >= 1 && dia <= 31) {
                        return true;
                    }
                    break;
                case 6:
                    if (dia >= 1 && dia <= 30) {
                        return true;
                    }
                    break;
                case 7:
                    if (dia >= 1 && dia <= 31) {
                        return true;
                    }
                    break;
                case 8:
                    if (dia >= 1 && dia <= 31) {
                        return true;
                    }
                    break;
                case 9:
                    if (dia >= 1 && dia <= 30) {
                        return true;
                    }
                    break;
                case 10:
                    if (dia >= 1 && dia <= 31) {
                        return true;
                    }
                    break;
                case 11:
                    if (dia >= 1 && dia <= 30) {
                        return true;
                    }
                    break;
                case 12:
                    if (dia >= 1 && dia <= 31) {
                        return true;
                    }
                    break;
                default:
                    return false;
            }
        }
        return false;
    }
    
    public static boolean comprobarHora(int hora, int minutos) {

        if (hora >= 0 && hora <= 24) {
            if (minutos >= 0 && minutos <= 60) {
                return true;
            }
        }
        return false;
    }
 
}//llave clase aplicacion agenda
