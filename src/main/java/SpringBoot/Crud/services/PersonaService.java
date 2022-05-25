package SpringBoot.Crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringBoot.Crud.models.Persona;
import SpringBoot.Crud.repository.IPersonaRepository;

@Service
public class PersonaService {
    @Autowired
    private IPersonaRepository personaRepository;

    public Persona create(Persona persona) {
        return this.personaRepository.save(persona);
    }

    public List<Persona> getAllPersonas() {
        return this.personaRepository.findAll();
    }

    public void delete(Persona persona) {
        this.personaRepository.delete(persona);
    }

    public Persona findById(Long id) {
        return this.personaRepository.findById(id).orElse(null);
    }

}
