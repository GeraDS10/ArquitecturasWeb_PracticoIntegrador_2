package Entidades;

public class ReporteCarrera {
    private String nombreCarrera;
    private int año;
    private long inscriptos;
    private long egresados;

    public ReporteCarrera(){

    }
    public ReporteCarrera(String nombreCarrera, int año, long inscriptos, long egresados) {
        this.nombreCarrera = nombreCarrera;
        this.año = año;
        this.inscriptos = inscriptos;
        this.egresados = egresados;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public long getInscriptos() {
        return inscriptos;
    }

    public void setInscriptos(long inscriptos) {
        this.inscriptos = inscriptos;
    }

    public long getEgresados() {
        return egresados;
    }

    public void setEgresados(long egresados) {
        this.egresados = egresados;
    }
}
