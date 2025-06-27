package ar.org.centro8.curso.tp3.servicios.repositories;

import ar.org.centro8.curso.tp3.servicios.connectors.Connector;
import ar.org.centro8.curso.tp3.servicios.entities.Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ServicioRepository {

    private Connection conn=Connector.getConnection();

    public void save(Servicio servicios){

        if(servicios == null) return;
        try (PreparedStatement ps = conn.prepareStatement(
            "insert into servicios (nombre, descripcion, tipo) values (?,?,?)",
            PreparedStatement.RETURN_GENERATED_KEYS)){
            ps.setString(1, servicios.getNombre());
            ps.setString(2, servicios.getDescripcion());
            ps.setString(3, servicios.getTipo());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();

            if(rs.next()) servicios.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void remove(Servicio servicios){

        if(servicios == null) return;
        try (PreparedStatement ps = conn.prepareStatement(
            "delete from servicio where id=?")){
            ps.setInt(1, servicios.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Servicio>getAll(){
        List<Servicio> list = new ArrayList<Servicio>();
        try (ResultSet rs = conn
                                .createStatement()
                                .executeQuery("select * from servicios")){
            while(rs.next()){
                list.add(new Servicio(
                                    rs.getInt("id"), 
                                    rs.getString("nombre"), 
                                    rs.getString("descripcion"),
                                    rs.getString("tipo")
                ));
            }

        } catch (Exception e) {
            System.out.println(e);

        }
        return list;
    }

    public Servicio getById(int id){
        return getAll()
                        .stream()
                        .filter(servicio->servicio.getId() == id)
                        .findFirst()
                        .orElse(new Servicio());
    }

    public List<Servicio>getLikeNombre(String nombre){

        if(nombre == null) return new ArrayList<Servicio>();
        return getAll()
                        .stream()
                        .filter(servicio->servicio
                                                .getNombre()
                                                .toLowerCase()
                                                .contains(nombre.toLowerCase()))
                        .toList();
    }
}