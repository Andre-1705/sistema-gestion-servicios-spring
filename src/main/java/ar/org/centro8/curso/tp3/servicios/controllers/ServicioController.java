package ar.org.centro8.curso.tp3.servicios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.org.centro8.curso.tp3.servicios.entities.Servicio;
import ar.org.centro8.curso.tp3.servicios.repositories.ServicioRepository;
import java.util.List;

@Controller
public class ServicioController {
    
    private String mensaje = "Ingrese nuevos servicios a asignar";
    
    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/servicio")
    public String getServicio(Model model, @RequestParam(name = "buscar",defaultValue = "")String buscar){
        
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("servicio", new Servicio());
        
        // Obtener servicios de la base de datos
        List<Servicio> servicios;
        if (!buscar.isEmpty()) {
            servicios = servicioRepository.findByNombreContainingIgnoreCase(buscar);
        } else {
            servicios = servicioRepository.findAllActivos();
        }
        
        model.addAttribute("likeNombre", servicios);
        
        return "servicio";
    }

    @PostMapping("/servicioSave")
    public String servicioSave(@ModelAttribute Servicio servicio){
        try {
            servicioRepository.save(servicio);
            mensaje = "Servicio guardado exitosamente";
        } catch (Exception e) {
            mensaje = "Error al guardar el servicio: " + e.getMessage();
            System.err.println("Error al guardar servicio: " + e);
        }
        
        return "redirect:servicio";
    }
}
