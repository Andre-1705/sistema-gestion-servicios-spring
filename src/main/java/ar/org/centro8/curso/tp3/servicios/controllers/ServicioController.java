package ar.org.centro8.curso.tp3.servicios.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.org.centro8.curso.tp3.servicios.entities.Servicio;
// import ar.org.centro8.curso.tp3.servicios.repositories.ServicioRepository;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ServicioController {
    
    private String mensaje = "Ingrese nuevos servicios a asignar";
    // private ServicioRepository servicioRepository = new ServicioRepository();

    @GetMapping("/servicio")
    public String getServicio(Model model, @RequestParam(name = "buscar",defaultValue = "")String buscar){
        
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("servicio", new Servicio());
        
        // Datos de ejemplo para mostrar en la tabla
        List<Servicio> serviciosEjemplo = new ArrayList<>();
        
        Servicio servicio1 = new Servicio();
        servicio1.setId(1);
        servicio1.setNombre("Desarrollo Web");
        servicio1.setTipo("Desarrollo");
        servicio1.setDescripcion("Creación de sitios web modernos y responsivos");
        serviciosEjemplo.add(servicio1);
        
        Servicio servicio2 = new Servicio();
        servicio2.setId(2);
        servicio2.setNombre("App Móvil");
        servicio2.setTipo("Desarrollo");
        servicio2.setDescripcion("Desarrollo de aplicaciones móviles nativas");
        serviciosEjemplo.add(servicio2);
        
        Servicio servicio3 = new Servicio();
        servicio3.setId(3);
        servicio3.setNombre("Consultoría IT");
        servicio3.setTipo("Consultoría");
        servicio3.setDescripcion("Asesoramiento en tecnologías de la información");
        serviciosEjemplo.add(servicio3);
        
        Servicio servicio4 = new Servicio();
        servicio4.setId(4);
        servicio4.setNombre("Soporte Técnico");
        servicio4.setTipo("Soporte");
        servicio4.setDescripcion("Soporte técnico especializado 24/7");
        serviciosEjemplo.add(servicio4);
        
        // Filtrar por búsqueda si se proporciona
        if (!buscar.isEmpty()) {
            List<Servicio> filtrados = new ArrayList<>();
            for (Servicio s : serviciosEjemplo) {
                if (s.getTipo().toLowerCase().contains(buscar.toLowerCase()) ||
                    s.getDescripcion().toLowerCase().contains(buscar.toLowerCase()) ||
                    s.getNombre().toLowerCase().contains(buscar.toLowerCase())) {
                    filtrados.add(s);
                }
            }
            model.addAttribute("likeNombre", filtrados);
        } else {
            model.addAttribute("likeNombre", serviciosEjemplo);
        }
        
        return "servicio";
    }

    @PostMapping("/servicioSave")
    public String servicioSave(@ModelAttribute Servicio servicio){
        
        // Simular guardado exitoso
        mensaje = "Servicio guardado exitosamente (modo demo)";
        
        return "redirect:servicio";
    }
}
