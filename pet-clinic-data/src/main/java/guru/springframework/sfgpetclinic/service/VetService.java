package guru.springframework.sfgpetclinic.service;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.Vet;

public interface VetService {
	Vet findById(Long id);
	Vet save(Vet vet);
	Set<Vet> findAll();
}
