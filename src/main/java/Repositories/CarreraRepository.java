package Repositories;

import Entidades.Carrera;
import Entidades.Estudiante;

import java.util.List;

public interface CarreraRepository {

    public void createCarrera(Carrera c);

    public void readCarreraWithInscriptosOrderByCantidad();

    public List<Estudiante> getEstudiantesFilterByCiudad(String ciudad);
}
