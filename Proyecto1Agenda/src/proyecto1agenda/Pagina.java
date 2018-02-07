package ejercicioagenda;

import java.util.*;

public class Pagina {
    
    private int dia;
    private int mes;
    private ArrayList<Cita> cita = new ArrayList();
    
    //constructor
    
    public Pagina(int dia, int mes){
        this.dia = dia;
        this.mes = mes;
    
    }
    
    //metodos
    
    public void añadirCita(Cita c){
        this.cita.add(c);
    }
    
    public void borrarCita(Cita c){
        for (int i=0;i<cita.size();i++){
            if (cita.getHora() && cita.getMinutos() == c.getMinutos()){
                this.cita.remove(cita)
            }
        
        }
    
    }
    
}//clase
