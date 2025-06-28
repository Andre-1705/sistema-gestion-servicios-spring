package ar.org.centro8.curso.tp3.servicios.repositories;

import ar.org.centro8.curso.tp3.servicios.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    
    @Query("SELECT e FROM Empleado e WHERE e.activo = true")
    List<Empleado> findAllActivos();
    
    @Query("SELECT e FROM Empleado e WHERE e.activo = true AND LOWER(e.apellido) LIKE LOWER(CONCAT('%', :apellido, '%'))")
    List<Empleado> findByApellidoContainingIgnoreCase(@Param("apellido") String apellido);
    
    @Query("SELECT e FROM Empleado e WHERE e.activo = true AND e.salario >= :salarioMinimo")
    List<Empleado> findBySalarioGreaterThanOrEqualTo(@Param("salarioMinimo") double salarioMinimo);
    
    @Query("SELECT e FROM Empleado e WHERE e.activo = true AND e.fecha_contrato >= :fechaDesde")
    List<Empleado> findByFechaContratoAfter(@Param("fechaDesde") LocalDate fechaDesde);
}
