package MySQLRepositories;

import Entidades.Estudiante;
import Repositories.EstudianteRepository;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class MySQLEstudianteRepository implements EstudianteRepository {

    private EntityManagerFactory emf = null;
    public MySQLEstudianteRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void createEstudiante(Estudiante e) {

    }

    public Estudiante getEstudianteByLibreta(int numeroLibreta) {
        return null;
    }

    public List<Estudiante> getEstudiantesOrderByEdad() {
        return null;
    }

    public List<Estudiante> getEstudiantesByGenero(String genero) {
        return null;
    }
}
