package Entidades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Carrera")
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String nombre;

    @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Inscripcion> inscripciones;

    public Carrera() {
        super();
        this.inscripciones = new ArrayList<Inscripcion>();
    }

    public Carrera(int id, String nombre) {
        this.nombre = nombre;
        this.inscripciones = new ArrayList<Inscripcion>();
    }
    public Carrera(String nombre) {
        this.nombre = nombre;
        this.inscripciones = new ArrayList<Inscripcion>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Inscripcion> getInscripciones() {
        return new ArrayList<Inscripcion>(this.inscripciones);
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
