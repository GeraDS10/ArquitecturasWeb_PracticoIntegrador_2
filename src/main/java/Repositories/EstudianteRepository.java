package Repositories;

import Entidades.Carrera;
import Entidades.Estudiante;

import java.util.List;

public interface EstudianteRepository {

    public void createEstudiante(Estudiante e);

    public Estudiante getEstudianteByLibreta(int numeroLibreta);
    public List<Estudiante> getEstudiantesOrderByApellido();

    public List<Estudiante> getEstudiantesOrderByEdad();

    public List<Estudiante> getEstudiantesByGenero(String genero);

    public List<Estudiante> getEstudiantesByCarreraAndCiudad(Carrera carrera, String ciudad);

}
