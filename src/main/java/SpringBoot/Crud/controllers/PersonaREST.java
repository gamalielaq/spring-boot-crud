package SpringBoot.Crud.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringBoot.Crud.models.Persona;
import SpringBoot.Crud.services.PersonaService;


@RestController
@RequestMapping("/api")
public class PersonaREST {
    
    @Autowired
    private PersonaService personaService;


    @GetMapping("/persona")
    private ResponseEntity<List<Persona>> listar() {
        try {
            return ResponseEntity.ok(this.personaService.getAllPersonas());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/persona")
    private ResponseEntity<Persona> save(@RequestBody Persona persona) {
        try {
            Persona temporal = this.personaService.create(persona);
            return ResponseEntity.created(new URI("/api/persona"+temporal.getId())).body(temporal);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @DeleteMapping("/persona")
    private ResponseEntity<Void> delete(@RequestBody Persona persona) {
        try {
            this.personaService.delete(persona);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/persona/{id}")
    private ResponseEntity<?> listId(@PathVariable Long id) {
        Persona persona = null;
        try {
            persona = this.personaService.findById(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if(persona != null) {    
            return new ResponseEntity<Persona>(persona, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
