package ar.org.centro8.curso.tp3.servicios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.org.centro8.curso.tp3.servicios.entities.Producto;
import ar.org.centro8.curso.tp3.servicios.repositories.ProductoRepository;
import java.util.List;

@Controller
public class ProductoController {
    
    private String mensaje = "Ingrese un nuevo Producto";
    
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/producto")
    public String getProducto(Model model, @RequestParam(name = "buscar", defaultValue = "") String buscar) {
        Producto producto = new Producto();
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("producto", producto);
        
        // Obtener productos de la base de datos
        List<Producto> productos;
        if (!buscar.isEmpty()) {
            productos = productoRepository.findByNombreContainingIgnoreCase(buscar);
        } else {
            productos = productoRepository.findAllActivos();
        }
        
        model.addAttribute("likeNombre", productos);
        
        return "producto";
    }

    @PostMapping("/productoSave")
    public String productoSave(@ModelAttribute Producto producto) {
        try {
            productoRepository.save(producto);
            mensaje = "Producto guardado exitosamente";
        } catch (Exception e) {
            mensaje = "Error al guardar el producto: " + e.getMessage();
            System.err.println("Error al guardar producto: " + e);
        }
        
        return "redirect:producto";
    }
} 