package edu.altair.apicrm.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tutorias", schema = "crm")
public class Tutoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tutoria")
    private Long idTutoria;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Column(name = "profesor", nullable = false, length = 150)
    private String profesor;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "disponible", nullable = false)
    private boolean disponible;

    public Tutoria() {}

    public Tutoria(Long idTutoria, String titulo, String descripcion,
                   String profesor, Double precio, boolean disponible) {
        this.idTutoria = idTutoria;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.profesor = profesor;
        this.precio = precio;
        this.disponible = disponible;
    }

    public Long getIdTutoria() { return idTutoria; }
    public void setIdTutoria(Long idTutoria) { this.idTutoria = idTutoria; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getProfesor() { return profesor; }
    public void setProfesor(String profesor) { this.profesor = profesor; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}
