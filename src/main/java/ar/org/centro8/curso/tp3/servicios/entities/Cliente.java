package ar.org.centro8.curso.tp3.servicios.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "apellido", nullable = false, length = 25)
    private String apellido;
    
    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;
    
    @Column(name = "edad", nullable = false)
    private int edad;
    
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    
    @Column(name = "telefono", length = 25)
    private String telefono;
    
    @Column(name = "activo", columnDefinition = "boolean default true")
    private boolean activo = true;
}

