package MySQLRepositories;

import Entidades.Carrera;
import Entidades.Estudiante;
import Repositories.EstudianteRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class MySQLEstudianteRepository implements EstudianteRepository {

    private EntityManagerFactory emf = null;
    public MySQLEstudianteRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void createEstudiante(Estudiante estudiante) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(estudiante);

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

    public Estudiante getEstudianteByLibreta(int numeroLibreta) {
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT e FROM Estudiante e WHERE e.numeroLibreta = :numeroLibreta";
        TypedQuery<Estudiante> query = em.createQuery(jpql, Estudiante.class);
        query.setParameter("numeroLibreta", numeroLibreta);

        List<Estudiante> estudiantes = query.getResultList();
        if (!estudiantes.isEmpty()) {
            return estudiantes.get(0);
        } else {
            return null;
        }
    }

    public List<Estudiante> getEstudiantesOrderByApellido() {
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT e FROM Estudiante e ORDER BY e.apellido DESC";
        TypedQuery<Estudiante> query = em.createQuery(jpql, Estudiante.class);
        return query.getResultList();
    }

    @Override
    public List<Estudiante> getEstudiantesOrderByEdad() {
        return null;
    }

    public List<Estudiante> getEstudiantesByGenero(String genero) {
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT e FROM Estudiante e WHERE e.genero = :genero";
        TypedQuery<Estudiante> query = em.createQuery(jpql, Estudiante.class);
        query.setParameter("genero", genero);
        return query.getResultList();
    }

    public List<Estudiante> getEstudiantesByCarreraAndCiudad(Carrera carrera, String ciudad) {
        EntityManager em = emf.createEntityManager();

        try {
            String jpql = "SELECT e FROM Estudiante e " +
                    "JOIN e.inscripciones i " +
                    "WHERE i.carrera = :carrera " +
                    "AND e.ciudad = :ciudad";

            TypedQuery<Estudiante> query = em.createQuery(jpql, Estudiante.class);
            query.setParameter("carrera", carrera);
            query.setParameter("ciudad", ciudad);

            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
