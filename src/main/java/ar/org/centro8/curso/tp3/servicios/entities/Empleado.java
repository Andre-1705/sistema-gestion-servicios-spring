package ar.org.centro8.curso.tp3.servicios.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "empleados")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "apellido", nullable = false, length = 25)
    private String apellido;
    
    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;
    
    @Column(name = "salario", nullable = false)
    private double salario;
    
    @Column(name = "fecha_contrato", nullable = false)
    private LocalDate fecha_contrato;
    
    @Column(name = "activo", columnDefinition = "boolean default true")
    private boolean activo = true;
}
