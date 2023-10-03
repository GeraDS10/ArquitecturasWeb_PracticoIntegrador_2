package Entidades;

import javax.persistence.*;

@Entity
@Table(name = "Inscipcion")
public class Inscripcion {

    @Id
    @ManyToOne
    @JoinColumn(name = "numeroDocumentoEstudiante")
    private Estudiante estudiante;

    @Id
    @ManyToOne
    @JoinColumn(name = "nombreCarrera")
    private Carrera carrera;

    @Column
    private int antiguedad;

    @Column
    private boolean seGraduo;

    public Inscripcion() {
        super();
    }

    public Inscripcion(Estudiante estudiante, Carrera carrera, int antiguedad) {
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.antiguedad = antiguedad;
        this.seGraduo = false;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public boolean isSeGraduo() {
        return seGraduo;
    }

    public void setSeGraduo(boolean seGraduo) {
        this.seGraduo = seGraduo;
    }
}
