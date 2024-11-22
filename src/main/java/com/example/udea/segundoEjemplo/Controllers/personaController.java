package com.example.udea.segundoEjemplo.Controllers;

import com.example.udea.segundoEjemplo.Entities.Persona;
import com.example.udea.segundoEjemplo.Services.personaService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class personaController {
    personaService servicio =new personaService();

    //Metodo para mostrar lista
    @GetMapping("listarPersonas")
    public ArrayList<Persona> listar(){
        return servicio.mostrar();
    }

    //Metodo para mostrar persona
    @GetMapping("mostrarPersona/{nombre}")
    public Persona buscar(@PathVariable String nombre){
        return servicio.buscarNombre(nombre);
    }

    //Metodo para agregar persona
    @PostMapping("agregarPersona")
    public String persona(@RequestBody Persona p){
        return servicio.agregarPersona(p);
    }

    //Metodo para modificar persona
    @PutMapping ("modificarPersona")
    public String modificarPersona(@RequestBody Persona p){
        return servicio.modificarPersona(p);
    }

    //Metodo para eliminar persona
    @DeleteMapping("eliminarPersona/{nombre}")
    public String eliminarPersona(@PathVariable String nombre) {
        return servicio.eliminarPersona(nombre);
    }


}
