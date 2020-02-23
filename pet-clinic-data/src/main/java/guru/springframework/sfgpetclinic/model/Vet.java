package guru.springframework.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vet")
public class Vet extends Person {

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "vet_speciality",
		joinColumns = @JoinColumn(name = "vet_id"),
		inverseJoinColumns = @JoinColumn(name = "specialty_id")
	)	
	private Set<Specialty> specialities = new HashSet<>();

	public Set<Specialty> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(Set<Specialty> specialities) {
		this.specialities = specialities;
	}
	
	
}
