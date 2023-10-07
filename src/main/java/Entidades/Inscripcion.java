package Entidades;

import javax.persistence.*;

@Entity
@IdClass(InscripcionId.class)
@Table(name = "Inscripcion")
public class Inscripcion{

    @Id
     @ManyToOne
    @JoinColumn(name = "Estudiante_dni")
    private Estudiante estudiante;

    @Id
    @ManyToOne
    @JoinColumn(name = "Carrera_id")
    private Carrera carrera;

    @Column
    private int antiguedad;

    @Column(name = "anio_inscripcion")
    private int anioInscripcion;

    @Column(name = "graduado")
    private boolean seGraduo;


    public Inscripcion() {
        super();
    }

    public Inscripcion(Estudiante estudiante, Carrera carrera, int antiguedad,int anioInscripcion, boolean seGraduo) {
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.antiguedad = antiguedad;
        this.anioInscripcion = anioInscripcion;
        this.seGraduo = seGraduo;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
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

    public int getAnioInscripcion() {
        return anioInscripcion;
    }

    public void setAnioInscripcion(int anioInscripcion) {
        this.anioInscripcion = anioInscripcion;
    }

    public boolean getSeGraduo() {
        return seGraduo;
    }

    public void setSeGraduo(boolean seGraduo) {
        this.seGraduo = seGraduo;
    }
}
