package MySQLRepositories;

import Entidades.Inscripcion;
import Repositories.InscripcionRepository;

import javax.persistence.EntityManagerFactory;

public class MySQLInscripcionRepository implements InscripcionRepository {

    private EntityManagerFactory emf = null;

    public MySQLInscripcionRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void createInscripcion(Inscripcion i) {

    }

    public Inscripcion readInscripcionByDni(int dni) {
        return null;
    }

    public Inscripcion readInscripcionByIdCarrera(int id) {
        return null;
    }
}
