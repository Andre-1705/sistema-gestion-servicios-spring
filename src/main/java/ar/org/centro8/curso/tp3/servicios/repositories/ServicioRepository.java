package ar.org.centro8.curso.tp3.servicios.repositories;

import ar.org.centro8.curso.tp3.servicios.entities.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
    
    @Query("SELECT s FROM Servicio s WHERE s.activo = true")
    List<Servicio> findAllActivos();
    
    @Query("SELECT s FROM Servicio s WHERE s.activo = true AND LOWER(s.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Servicio> findByNombreContainingIgnoreCase(@Param("nombre") String nombre);
    
    @Query("SELECT s FROM Servicio s WHERE s.activo = true AND s.tipo = :tipo")
    List<Servicio> findByTipo(@Param("tipo") String tipo);
}