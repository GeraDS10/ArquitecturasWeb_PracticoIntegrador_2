package MySQLRepositories;

import Entidades.Carrera;
import Entidades.Estudiante;
import Repositories.CarreraRepository;
import RepositoryFactory.MySQLRepositoryFactory;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class MySQLCarreraRepository implements CarreraRepository {
    private EntityManagerFactory emf = null;

    public MySQLCarreraRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void createCarrera(Carrera c) {

    }

    public void readCarreraWithInscriptosOrderByCantidad() {

    }

    public List<Estudiante> getEstudiantesFilterByCiudad(String ciudad) {
        return null;
    }
}
