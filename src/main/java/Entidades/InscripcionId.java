package Entidades;

import java.io.Serializable;

public class InscripcionId implements Serializable {
   private Estudiante estudiante;
    private Carrera carrera;

    public InscripcionId() {
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}
