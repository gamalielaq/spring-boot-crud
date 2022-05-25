package SpringBoot.Crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringBoot.Crud.models.Persona;

public interface IPersonaRepository extends JpaRepository<Persona, Long> {
    
}
