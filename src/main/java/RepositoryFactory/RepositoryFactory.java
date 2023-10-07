package RepositoryFactory;

import Entidades.ReporteCarrera;
import Repositories.CarreraRepository;
import Repositories.EstudianteRepository;
import Repositories.InscripcionRepository;
import Repositories.ReporteCarreraRepository;


import javax.persistence.EntityManagerFactory;

public abstract class RepositoryFactory {

    public static RepositoryFactory createFactory(int type) {
        switch (type) {
            case 1:
                System.out.println("Creando MySQLRepositoryFactory");
                return new MySQLRepositoryFactory();
        }
        return null;
    }

    public abstract EntityManagerFactory createEntityManagerFactory();

    public abstract CarreraRepository getCarreraRepository();
    public abstract EstudianteRepository getEstudianteRepository();
    public abstract InscripcionRepository getInscripcionRepository();

    public abstract ReporteCarreraRepository getReporteCarreras();
}
