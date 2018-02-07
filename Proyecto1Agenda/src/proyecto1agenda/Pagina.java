package proyecto1agenda;

import java.util.*;

public class Pagina {
    
    private int dia;
    private int mes;
    private ArrayList<Cita> cita = new ArrayList();
    
    //constructor
    
    Pagina(int dia, int mes){
        this.dia = dia;
        this.mes = mes;
    }
    
    //metodos
    
    public void leerPagina() {
        StringBuilder st = new StringBuilder(this.getDia() + "/" + this.getMes() + "\n");
        
        if (this.cita.isEmpty()) {
            st.append("La página está en blanco.\n");
        } else {
            for (int i=0;i<this.cita.size();i++){
                st.append(this.cita.get(i).leerCita());
            }
          }
        System.out.println(st.toString());
    }
    
    public void añadirCita(Cita c){
        this.cita.add(c);
    }
    
    public void borrarCita(Cita c){
        for (int i=0;i<cita.size();i++){
            if (cita.get(i).getHora() == c.getHora() && cita.get(i).getMinutos() == c.getMinutos()) {
                this.cita.remove(i);
            }
        }
    }
    
    public Cita buscarCita (int hora, int minutos){
        Cita busqueda = null, temp;
        int cont = 0;
        boolean encontrado = false;
    
        while (cont < this.cita.size() && encontrado == false) {
            temp = this.cita.get(cont++);
            if (temp.getHora () == hora && temp.getMinutos() == minutos){
                busqueda = temp;
                encontrado = true;
            }
        }
        return busqueda;
        
        
        /* de otra forma
        for (Cita temp: this.citas){
            if (temp.getHora() == c.getHora() && temp.getMinustos() == c.getMinutos(){
                return temp;
            }
        }
        return null;
        */
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public ArrayList<Cita> getCita() {
        return cita;
    }

    public void setCita(ArrayList<Cita> cita) {
        this.cita = cita;
    }
}//clase
