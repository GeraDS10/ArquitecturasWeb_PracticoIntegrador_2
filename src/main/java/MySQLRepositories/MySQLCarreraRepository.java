package MySQLRepositories;

import Entidades.Carrera;
import Entidades.Estudiante;
import Repositories.CarreraRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class MySQLCarreraRepository implements CarreraRepository {
    private EntityManagerFactory emf = null;

    public MySQLCarreraRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }


    public void createCarrera(Carrera c) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(c);

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

    public Carrera getCarreraByName(String name){
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT c FROM Carrera c WHERE c.nombre = :nombre";
        TypedQuery<Carrera> query = em.createQuery(jpql, Carrera.class);
        query.setParameter("nombre", name);

        List<Carrera> carreras = query.getResultList();
        if (!carreras.isEmpty()) {
            return carreras.get(0);
        } else {
            return null;
        }
    }


    public List<Carrera> readCarreraWithInscriptosOrderByCantidad() {
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT c, COUNT(i) AS cantidadInscripciones " +
                "FROM Carrera c " +
                "LEFT JOIN c.inscripciones i " +
                "GROUP BY c " +
                "ORDER BY cantidadInscripciones DESC";
        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
        List<Object[]> results = query.getResultList();
        List<Carrera> carreras = new ArrayList<>();
        for (Object[] result : results) {
            Carrera carrera = (Carrera) result[0];
            carreras.add(carrera);
        }

        return carreras;
    }

    public List<Estudiante> getEstudiantesFilterByCiudad(String ciudad) {
        return null;
    }
}
