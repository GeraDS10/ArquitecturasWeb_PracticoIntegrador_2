package Repositories;

import Entidades.Estudiante;

import java.util.List;

public interface EstudianteRepository {

    public void createEstudiante(Estudiante e);

    public Estudiante getEstudianteByLibreta(int numeroLibreta);

    public List<Estudiante> getEstudiantesOrderByEdad();

    public List<Estudiante> getEstudiantesByGenero(String genero);

}
