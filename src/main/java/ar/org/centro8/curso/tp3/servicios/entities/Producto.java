package ar.org.centro8.curso.tp3.servicios.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    
    @Column(name = "precio", nullable = false)
    private double precio;
    
    @Column(name = "stock", nullable = false)
    private int stock;
    
    @Column(name = "activo", columnDefinition = "boolean default true")
    private boolean activo = true;
}
