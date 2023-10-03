package Entidades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Estudiante")
public class Estudiante {
    @Id
    private int dni;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private int edad;

    @Column
    private String genero;

    @Column
    private String ciudad;

    @Column
    private int numeroLibreta;

    @OneToMany
    List<Inscripcion> inscripciones;



    public Estudiante() {
        super();
        this.inscripciones = new ArrayList<Inscripcion>();
    }

    public Estudiante(int dni, String nombre, String apellido, int edad, String genero, String ciudad, int numeroLibreta) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudad = ciudad;
        this.numeroLibreta = numeroLibreta;
        this.inscripciones = new ArrayList<Inscripcion>();
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getNumeroLibreta() {
        return numeroLibreta;
    }

    public void setNumeroLibreta(int numeroLibreta) {
        this.numeroLibreta = numeroLibreta;
    }

    public List<Inscripcion> getInscripciones() {
        return new ArrayList<Inscripcion>(this.inscripciones);
    }
}
