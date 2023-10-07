package Repositories;

import Entidades.Carrera;
import Entidades.Estudiante;

import java.util.List;

public interface CarreraRepository {

    public void createCarrera(Carrera c);
    public Carrera getCarreraByName(String name);

    public List<Carrera> readCarreraWithInscriptosOrderByCantidad();

    public List<Estudiante> getEstudiantesFilterByCiudad(String ciudad);
}
