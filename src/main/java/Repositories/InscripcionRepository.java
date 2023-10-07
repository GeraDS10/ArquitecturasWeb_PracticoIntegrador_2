package Repositories;

import Entidades.Carrera;
import Entidades.Estudiante;
import Entidades.Inscripcion;

public interface InscripcionRepository {

    public void createInscripcion(Inscripcion i);

    public Inscripcion readInscripcionByDni(int dni);

    public Inscripcion readInscripcionByIdCarrera(int id);

}
