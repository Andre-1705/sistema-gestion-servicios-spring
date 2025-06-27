package ar.org.centro8.curso.tp3.servicios.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ar.org.centro8.curso.tp3.servicios.entities.Cliente;
// import ar.org.centro8.curso.tp3.servicios.repositories.ClienteRepository;
// import ar.org.centro8.curso.tp3.servicios.repositories.ServicioRepository;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ClienteController {
    
    private String mensaje = "Ingrese un nuevo Cliente";
    // private ClienteRepository clienteRepository = new ClienteRepository();
    // private ServicioRepository servicioRepository = new ServicioRepository();

    @GetMapping("/cliente")
    public String getCliente(Model model, @RequestParam(name = "buscar", defaultValue = "") String buscar) {
        Cliente cliente = new Cliente();
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("cliente", cliente);
        
        // Datos de ejemplo para mostrar en la tabla
        List<Cliente> clientesEjemplo = new ArrayList<>();
        Cliente cliente1 = new Cliente();
        cliente1.setId(1);
        cliente1.setNombre("Juan");
        cliente1.setApellido("Pérez");
        cliente1.setEdad(30);
        cliente1.setEmail("juan.perez@email.com");
        cliente1.setTelefono("123456789");
        clientesEjemplo.add(cliente1);
        
        Cliente cliente2 = new Cliente();
        cliente2.setId(2);
        cliente2.setNombre("María");
        cliente2.setApellido("García");
        cliente2.setEdad(25);
        cliente2.setEmail("maria.garcia@email.com");
        cliente2.setTelefono("987654321");
        clientesEjemplo.add(cliente2);
        
        Cliente cliente3 = new Cliente();
        cliente3.setId(3);
        cliente3.setNombre("Carlos");
        cliente3.setApellido("López");
        cliente3.setEdad(35);
        cliente3.setEmail("carlos.lopez@email.com");
        cliente3.setTelefono("555666777");
        clientesEjemplo.add(cliente3);
        
        // Filtrar por búsqueda si se proporciona
        if (!buscar.isEmpty()) {
            List<Cliente> filtrados = new ArrayList<>();
            for (Cliente c : clientesEjemplo) {
                if (c.getApellido().toLowerCase().contains(buscar.toLowerCase()) ||
                    c.getNombre().toLowerCase().contains(buscar.toLowerCase())) {
                    filtrados.add(c);
                }
            }
            model.addAttribute("likeApellido", filtrados);
        } else {
            model.addAttribute("likeApellido", clientesEjemplo);
        }
        
        return "cliente";
    }

    @PostMapping("/clienteSave")
    public String clienteSave(@ModelAttribute Cliente cliente) {
        System.out.println("******************************************");
        System.out.println(cliente);
        System.out.println("******************************************");
        
        // Simular guardado exitoso
        mensaje = "Cliente guardado exitosamente (modo demo)";
        
        return "redirect:cliente";
    }
}
