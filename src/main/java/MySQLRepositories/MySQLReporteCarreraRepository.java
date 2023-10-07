package MySQLRepositories;

import Entidades.ReporteCarrera;
import Repositories.ReporteCarreraRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class MySQLReporteCarreraRepository implements ReporteCarreraRepository {
    private EntityManagerFactory emf = null;

    public MySQLReporteCarreraRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }


    @Override
    public List<ReporteCarrera> generarReporteCarreras() {
        EntityManager em = emf.createEntityManager();

        try {
            String jpql = "SELECT c.nombre, i.anioInscripcion, COUNT(i) AS inscriptos, SUM(CASE WHEN i.seGraduo = true THEN 1 ELSE 0 END) AS egresados " +
                    "FROM Carrera c " +
                    "LEFT JOIN c.inscripciones i " +
                    "GROUP BY c.nombre, i.anioInscripcion " +
                    "ORDER BY c.nombre ASC, i.anioInscripcion ASC";

            TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
            List<Object[]> results = query.getResultList();

            List<ReporteCarrera> reporte = new ArrayList<>();

            for (Object[] result : results) {
                ReporteCarrera reporteCarrera = new ReporteCarrera();
                reporteCarrera.setNombreCarrera((String) result[0]);
                reporteCarrera.setAño((int) result[1]);
                reporteCarrera.setInscriptos(((Long) result[2]).intValue());
                reporteCarrera.setEgresados(((Long) result[3]).intValue());
                reporte.add(reporteCarrera);
            }

            return reporte;
        } finally {
            em.close();
        }
    }
}
