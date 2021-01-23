package com.udacity.jdnd.course3.critter.presentation.pet;

import com.udacity.jdnd.course3.critter.persistence.Pet;
import com.udacity.jdnd.course3.critter.persistence.PetRepository;
import com.udacity.jdnd.course3.critter.service.AllPetsByOwnerFetchingService;
import com.udacity.jdnd.course3.critter.service.PetCreatingService;
import com.udacity.jdnd.course3.critter.service.PetFetchingService;
import com.udacity.jdnd.course3.critter.service.PetNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    PetCreatingService petCreatingService;

    @Autowired
    PetFetchingService petFetchingService;

    @Autowired
    AllPetsByOwnerFetchingService allPetsByOwnerFetchingService;

    @Autowired
    PetConverter petConverter;

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        Pet pet = petConverter.toDomain(petDTO);
        Pet newPet = petCreatingService.apply(pet);
        return petConverter.fromDomain(newPet);
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        Pet pet = petFetchingService.apply(petId)
                .orElseThrow(() -> new PetNotFoundException(petId));
        return petConverter.fromDomain(pet);
    }

    @GetMapping
    public List<PetDTO> getPets(){
        throw new UnsupportedOperationException();
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        List<Pet> retrievedPets = allPetsByOwnerFetchingService.apply(ownerId);
        return retrievedPets.stream()
                .map(pet -> petConverter.fromDomain(pet))
                .collect(Collectors.toList());
    }
}
