package ar.org.centro8.curso.tp3.servicios.repositories;

import ar.org.centro8.curso.tp3.servicios.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
    @Query("SELECT c FROM Cliente c WHERE c.activo = true")
    List<Cliente> findAllActivos();
    
    @Query("SELECT c FROM Cliente c WHERE c.activo = true AND (LOWER(c.apellido) LIKE LOWER(CONCAT('%', :buscar, '%')) OR LOWER(c.nombre) LIKE LOWER(CONCAT('%', :buscar, '%')))")
    List<Cliente> findByApellidoOrNombreContainingIgnoreCase(@Param("buscar") String buscar);
    
    @Query("SELECT c FROM Cliente c WHERE c.activo = true AND LOWER(c.apellido) LIKE LOWER(CONCAT('%', :apellido, '%'))")
    List<Cliente> findByApellidoContainingIgnoreCase(@Param("apellido") String apellido);
}