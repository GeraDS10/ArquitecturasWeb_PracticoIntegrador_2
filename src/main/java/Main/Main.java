package Main;

import Entidades.Carrera;
import Entidades.Estudiante;
import Entidades.Inscripcion;
import Entidades.ReporteCarrera;
import Repositories.CarreraRepository;
import Repositories.EstudianteRepository;
import Repositories.InscripcionRepository;
import Repositories.ReporteCarreraRepository;
import RepositoryFactory.RepositoryFactory;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        RepositoryFactory sql = RepositoryFactory.createFactory(1);
        CarreraRepository carreraRepository = sql.getCarreraRepository();
        EstudianteRepository estudianteRepository = sql.getEstudianteRepository();
        InscripcionRepository inscripcionRepository = sql.getInscripcionRepository();
        ReporteCarreraRepository reporteCarreraRepository = sql.getReporteCarreras();

        /*
        -------------------------------------- Carga de Estudiantes - Carreras - Inscripcion----------------------

         */
        Carrera c1 = new Carrera("contador");
        Carrera c2 = new Carrera("Licenciado");
        Carrera c3 = new Carrera("Ingeniero");
        carreraRepository.createCarrera(c1);
        carreraRepository.createCarrera(c2);
        carreraRepository.createCarrera(c3);

        Estudiante e1 = new Estudiante(10123123, "Juan", "Carlos", 20, "Masculino", "Tandil", 1);
        Estudiante e2 = new Estudiante(11123123, "Pedro", "Perez", 21, "Masculino", "Barker", 2);
        Estudiante e3 = new Estudiante(12123123, "Raul", "Rodriguez", 22, "Masculino", "Vela", 3);
        Estudiante e4 = new Estudiante(13123123, "Maria", "Marquez", 19, "Femenino", "Tandil", 4);
        Estudiante e5 = new Estudiante (9123123, "Paula", "Pareto", 24, "Femenino", "Balcarce", 5);

        estudianteRepository.createEstudiante(e1);
        estudianteRepository.createEstudiante(e2);
        estudianteRepository.createEstudiante(e3);
        estudianteRepository.createEstudiante(e4);
        estudianteRepository.createEstudiante(e5);

        Estudiante primero = estudianteRepository.getEstudianteByLibreta(1);
        Estudiante segundo = estudianteRepository.getEstudianteByLibreta(2);
        Estudiante tercero = estudianteRepository.getEstudianteByLibreta(3);
        Estudiante cuarto = estudianteRepository.getEstudianteByLibreta(4);
        Estudiante quinto = estudianteRepository.getEstudianteByLibreta(5);


        Carrera licenciado = carreraRepository.getCarreraByName("licenciado");
        Carrera contador = carreraRepository.getCarreraByName("contador");
        Carrera ingeniero = carreraRepository.getCarreraByName("ingeniero");


        Inscripcion i = new Inscripcion(primero, contador, 1,2020, false);
        inscripcionRepository.createInscripcion(i);
        Inscripcion i2 = new Inscripcion(segundo, contador, 2,2021, false);
        inscripcionRepository.createInscripcion(i2);
        Inscripcion i3 = new Inscripcion(tercero, contador, 3,2022, true);
        inscripcionRepository.createInscripcion(i3);
        Inscripcion i4 = new Inscripcion(cuarto, contador, 1,2020, false);
        inscripcionRepository.createInscripcion(i4);
        Inscripcion i5 = new Inscripcion(quinto, contador, 3,2021, true);
        inscripcionRepository.createInscripcion(i5);

        Inscripcion i6 = new Inscripcion(quinto, licenciado, 3,2022, true);
        inscripcionRepository.createInscripcion(i6);
        Inscripcion i7 = new Inscripcion(primero, licenciado, 5,2023, true);
        inscripcionRepository.createInscripcion(i7);
        Inscripcion i8 = new Inscripcion(segundo, licenciado, 1,2021, false);
        inscripcionRepository.createInscripcion(i8);

        Inscripcion i9 = new Inscripcion(segundo, licenciado, 6,2020, true);
        inscripcionRepository.createInscripcion(i9);
        Inscripcion i10 = new Inscripcion(cuarto, licenciado, 1,2022, false);
        inscripcionRepository.createInscripcion(i10);



        Inscripcion i11 = new Inscripcion(primero, ingeniero, 3,2021, true);
        inscripcionRepository.createInscripcion(i11);
        Inscripcion i12 = new Inscripcion(tercero, ingeniero, 2,2023, false);
        inscripcionRepository.createInscripcion(i12);
        Inscripcion i13 = new Inscripcion(quinto, ingeniero, 5,2022, true);
        inscripcionRepository.createInscripcion(i13);
        /*
        --------------------------------------Fin carga-------------------------------------------------------
         */




        /*
        -------------------------------------------- Consultas ---------------------------------------------------------
*/
        List<Estudiante> estudiantesByApellido = estudianteRepository.getEstudiantesOrderByApellido();
        System.out.println("Estudiantes ordenados por Apellido");
        for (Estudiante e: estudiantesByApellido
             ) {

            System.out.println(e);
        }

        List<Estudiante> estudiantesByGenero = estudianteRepository.getEstudiantesByGenero("masculino");
        System.out.println();
        System.out.println("Estudiantes por genero");
        for (Estudiante e: estudiantesByGenero
             ) {
            System.out.println(e);
        }

        List<Carrera> carrerasConInscriptosOrderByCantidad = carreraRepository.readCarreraWithInscriptosOrderByCantidad();
        System.out.println();
        System.out.println("Carreras con inscriptos ordenadas por cantidad");
        for (Carrera c: carrerasConInscriptosOrderByCantidad
             ) {
            System.out.println(c);
        }

        Carrera c = carreraRepository.getCarreraByName("contador");
        List<Estudiante> estudiantesFilterByCarreraAndCiudad = estudianteRepository.getEstudiantesByCarreraAndCiudad(c , "Tandil");
        System.out.println();
        System.out.println("Estudiantes filtrados por carrera y ciudad");
        for (Estudiante e: estudiantesFilterByCarreraAndCiudad
             ) {
            System.out.println(e);
        }

        List<ReporteCarrera> reporte = reporteCarreraRepository.generarReporteCarreras();
        System.out.println();
        System.out.println("Reporte de carreras");
        for (ReporteCarrera reporteCarrera : reporte) {
            System.out.println("Carrera: " + reporteCarrera.getNombreCarrera());
            System.out.println("Año: " + reporteCarrera.getAño());
            System.out.println("Inscriptos: " + reporteCarrera.getInscriptos());
            System.out.println("Egresados: " + reporteCarrera.getEgresados());
            System.out.println();
        }






    }
}
