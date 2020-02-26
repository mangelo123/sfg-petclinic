package guru.springframework.sfgpetclinic.service.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.model.Owner;

class OwnerServiceMapTest {

	OwnerServiceMap ownerMapService;
	final Long ownerId = 1L;
	final String lastName = "Smith";
	
	@BeforeEach
	void setUp() throws Exception {
		ownerMapService = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
		
		ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
	}

	@Test
	void testFindAll() {
		Set<Owner> owners = ownerMapService.findAll();
		
		assertEquals(1, owners.size());
	}

	@Test
	void testFindByIdLong() {
		Owner owner = ownerMapService.findById(ownerId);
		
		assertEquals(ownerId, owner.getId());
	}

	@Test
	void testSaveExistingId() {
		Long id = 2L;
		Owner owner2 = Owner.builder().id(id).build();
		Owner savedOwner = ownerMapService.save(owner2);
		
		assertEquals(id, savedOwner.getId());
	}

	@Test
	void testSaveNoId() {
		Owner savedOwner = ownerMapService.save(Owner.builder().build());
		
		assertNotNull(savedOwner);
		assertNotNull(savedOwner.getId());
	}

	
	@Test
	void testDeleteOwner() {
		ownerMapService.delete(ownerMapService.findById(ownerId));
		
		assertEquals(0, ownerMapService.findAll().size());
	}

	@Test
	void testDeleteByIdLong() {
		ownerMapService.deleteById(ownerId);
		
		assertEquals(0, ownerMapService.findAll().size());
	}

	@Test
	void testFindByLastName() {
		Owner smith = ownerMapService.findByLastName(lastName);
		
		assertNotNull(smith);
		assertEquals(lastName, smith.getLastName());
	}

	@Test
	void testFindByNotFound() {
		Owner smith = ownerMapService.findByLastName("foo");
		
		assertNull(smith);
	}
	
}
