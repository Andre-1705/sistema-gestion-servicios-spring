package ar.org.centro8.curso.tp3.servicios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ar.org.centro8.curso.tp3.servicios.entities.Cliente;
import ar.org.centro8.curso.tp3.servicios.repositories.ClienteRepository;
// import ar.org.centro8.curso.tp3.servicios.repositories.ServicioRepository;
import java.util.List;

@Controller
public class ClienteController {
    
    private String mensaje = "Ingrese un nuevo Cliente";
    // private ClienteRepository clienteRepository = new ClienteRepository();
    // private ServicioRepository servicioRepository = new ServicioRepository();

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/cliente")
    public String getCliente(Model model, @RequestParam(name = "buscar", defaultValue = "") String buscar) {
        Cliente cliente = new Cliente();
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("cliente", cliente);
        
        // Obtener clientes de la base de datos
        List<Cliente> clientes;
        if (!buscar.isEmpty()) {
            clientes = clienteRepository.findByApellidoOrNombreContainingIgnoreCase(buscar);
        } else {
            clientes = clienteRepository.findAllActivos();
        }
        
        model.addAttribute("likeApellido", clientes);
        
        return "cliente";
    }

    @PostMapping("/clienteSave")
    public String clienteSave(@ModelAttribute Cliente cliente) {
        try {
            clienteRepository.save(cliente);
            mensaje = "Cliente guardado exitosamente";
        } catch (Exception e) {
            mensaje = "Error al guardar el cliente: " + e.getMessage();
            System.err.println("Error al guardar cliente: " + e);
        }
        
        return "redirect:cliente";
    }
}
