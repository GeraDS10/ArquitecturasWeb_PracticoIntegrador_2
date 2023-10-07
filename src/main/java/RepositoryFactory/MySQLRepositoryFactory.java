package RepositoryFactory;

import Entidades.ReporteCarrera;
import MySQLRepositories.MySQLCarreraRepository;
import MySQLRepositories.MySQLEstudianteRepository;
import MySQLRepositories.MySQLInscripcionRepository;
import MySQLRepositories.MySQLReporteCarreraRepository;
import Repositories.CarreraRepository;
import Repositories.EstudianteRepository;
import Repositories.InscripcionRepository;
import Repositories.ReporteCarreraRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MySQLRepositoryFactory extends RepositoryFactory {

    private EntityManagerFactory emf = null;

    public MySQLRepositoryFactory(){

    }

    public EntityManagerFactory createEntityManagerFactory(){
        if (emf == null){
            emf = Persistence.createEntityManagerFactory("arquitecturasweb");
        }
        return this.emf;
    }

    @Override
    public CarreraRepository getCarreraRepository(){
        return new MySQLCarreraRepository(this.createEntityManagerFactory());
    }

    public EstudianteRepository getEstudianteRepository() {
        return new MySQLEstudianteRepository(this.createEntityManagerFactory());
    }

    public InscripcionRepository getInscripcionRepository() {
        return new MySQLInscripcionRepository(this.createEntityManagerFactory());
    }

    @Override
    public ReporteCarreraRepository getReporteCarreras() {
        return new MySQLReporteCarreraRepository(this.createEntityManagerFactory());
    }


}
