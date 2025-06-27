package ar.org.centro8.curso.tp3.servicios.controllers;

// import ar.org.centro8.curso.tp3.servicios.utils.Properties;
// import ar.org.centro8.curso.tp3.servicios.connectors.Connector;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfiguracionController {
    
    @GetMapping("/configuracion")
    public String getConfiguracion(Model model){

        // Datos de ejemplo para mostrar en configuración
        model.addAttribute("so", "Windows 10 Pro");
        model.addAttribute("java", "Java 21.0.7");
        model.addAttribute("user", "maria");
        model.addAttribute("location", "D:\\Andrea\\Servicios");
        model.addAttribute("ip", "192.168.1.100");
        model.addAttribute("date", "2024-06-27 19:30:00");
        model.addAttribute("jdbc", "jdbc:postgresql://localhost:5432/servicios");
        
        return "configuracion";
    }
}
    