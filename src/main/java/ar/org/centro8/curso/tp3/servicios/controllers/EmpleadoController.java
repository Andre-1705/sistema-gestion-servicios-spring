package ar.org.centro8.curso.tp3.servicios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.org.centro8.curso.tp3.servicios.entities.Empleado;
import ar.org.centro8.curso.tp3.servicios.repositories.EmpleadoRepository;
import java.util.List;

@Controller
public class EmpleadoController {
    
    private String mensaje = "Ingrese un nuevo Empleado";
    
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping("/empleado")
    public String getEmpleado(Model model, @RequestParam(name = "buscar", defaultValue = "") String buscar) {
        Empleado empleado = new Empleado();
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("empleado", empleado);
        
        // Obtener empleados de la base de datos
        List<Empleado> empleados;
        if (!buscar.isEmpty()) {
            empleados = empleadoRepository.findByApellidoContainingIgnoreCase(buscar);
        } else {
            empleados = empleadoRepository.findAllActivos();
        }
        
        model.addAttribute("likeApellido", empleados);
        
        return "empleado";
    }

    @PostMapping("/empleadoSave")
    public String empleadoSave(@ModelAttribute Empleado empleado) {
        try {
            empleadoRepository.save(empleado);
            mensaje = "Empleado guardado exitosamente";
        } catch (Exception e) {
            mensaje = "Error al guardar el empleado: " + e.getMessage();
            System.err.println("Error al guardar empleado: " + e);
        }
        
        return "redirect:empleado";
    }
} 