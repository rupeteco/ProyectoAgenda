package proyecto1agenda;

public class Cita {
    private int hora;
    private int minutos;
    private String titulo;
    private String texto;
    
    //constructur
    
    Cita (){}

    public Cita(int hora, int minutos, String titulo, String texto) {
        this.hora = hora;
        this.minutos = minutos;
        this.titulo = titulo;
        this.texto = texto;
    }
   
    //metodos
    
    public String leerCita(){
        StringBuilder st = new StringBuilder();
        st.append("").append(this.getHora()).append(":").append(this.getMinutos()).append(" - ");
        st.append(this.getTitulo()).append("\n");
        st.append(this.getTexto()).append("\n\n");
        
        return st.toString();
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }  
}
