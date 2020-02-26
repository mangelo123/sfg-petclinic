package guru.springframework.sfgpetclinic.repository;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.sfgpetclinic.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {

}
