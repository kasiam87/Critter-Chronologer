package com.udacity.jdnd.course3.critter.presentation.pet;

import com.udacity.jdnd.course3.critter.persistence.Pet;
import com.udacity.jdnd.course3.critter.service.AllPetsByOwnerFetchingService;
import com.udacity.jdnd.course3.critter.service.AllPetsFetchingService;
import com.udacity.jdnd.course3.critter.service.PetCreatingService;
import com.udacity.jdnd.course3.critter.service.PetFetchingService;
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
    AllPetsFetchingService allPetsFetchingService;

    @Autowired
    PetConverter petConverter;

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        Pet pet = petConverter.toDomain(petDTO);
        Pet newPet = petCreatingService.invoke(pet);
        return petConverter.fromDomain(newPet);
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        Pet pet = petFetchingService.invoke(petId);
        return petConverter.fromDomain(pet);
    }

    @GetMapping
    public List<PetDTO> getPets(){
        return allPetsFetchingService.invoke().stream()
                .map(c -> petConverter.fromDomain(c)).collect(Collectors.toList());
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        List<Pet> retrievedPets = allPetsByOwnerFetchingService.invoke(ownerId);
        return retrievedPets.stream()
                .map(pet -> petConverter.fromDomain(pet))
                .collect(Collectors.toList());
    }
}
