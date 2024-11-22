package com.example.udea.segundoEjemplo.Services;

import com.example.udea.segundoEjemplo.Entities.Persona;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class personaService {

    private ArrayList<Persona> lista = new ArrayList<>();

    // Constructor con datos iniciales
    public personaService() {
        lista.add(new Persona("Martin", "Foronda", 30, "Soltero", LocalDate.of(1993, 5, 10)));
        lista.add(new Persona("Julian", "Rojas", 25, "Casado", LocalDate.of(1998, 3, 15)));
        lista.add(new Persona("Fernando", "Arango", 40, "Divorciado", LocalDate.of(1983, 8, 22)));
    }

    // Metodo listar persona
    public ArrayList<Persona> mostrar() {
        return lista;
    }

    // Metodo buscar persona
    public Persona buscarNombre(String nombre) {
        for (Persona persona : lista) {
            if (persona.getNombre().equals(nombre)) {
                return persona;
            }
        }
        return null;
    }

    // Metodo agregar persona
    public String agregarPersona(Persona persona) {
        lista.add(persona);
        return "¡Registro exitoso!";
    }

    // Metodo modificar persona
    public String modificarPersona(Persona p) {
        for (Persona persona : lista) {
            if (persona.getNombre().equals(p.getNombre())) { // Buscar por nombre
                persona.setApellido(p.getApellido());
                persona.setEdad(p.getEdad());
                persona.setEstadoCivil(p.getEstadoCivil());
                persona.setFecha(p.getFecha());
                return "¡Persona modificada con éxito!";
            }
        }
        return "Persona no encontrada";
    }

    // Metodo eliminar
    public String eliminarPersona(String nombre) {
        Iterator<Persona> iterator = lista.iterator(); // Usar un iterador para eliminar de forma segura
        while (iterator.hasNext()) {
            Persona persona = iterator.next();
            if (persona.getNombre().equals(nombre)) {
                iterator.remove();
                return "¡Persona eliminada con éxito!";
            }
        }
        return "Persona no encontrada";
    }
}
