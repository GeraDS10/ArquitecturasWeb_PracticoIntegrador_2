package MySQLRepositories;

import Entidades.Carrera;
import Entidades.Estudiante;
import Entidades.Inscripcion;
import Repositories.InscripcionRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class MySQLInscripcionRepository implements InscripcionRepository {

    private EntityManagerFactory emf = null;

    public MySQLInscripcionRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void createInscripcion(Inscripcion i) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Carrera carrera = em.find(Carrera.class, i.getCarrera().getId());
            Estudiante estudiante = em.find(Estudiante.class, i.getEstudiante().getDni());

            Inscripcion inscripcion = new Inscripcion();
            inscripcion.setCarrera(carrera);
            inscripcion.setEstudiante(estudiante);
            inscripcion.setAntiguedad(i.getAntiguedad());
            inscripcion.setAnioInscripcion(i.getAnioInscripcion());
            inscripcion.setSeGraduo(i.getSeGraduo());

            em.persist(inscripcion);

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Inscripcion readInscripcionByDni(int dni) {
        return null;
    }

    public Inscripcion readInscripcionByIdCarrera(int id) {
        return null;
    }
}
