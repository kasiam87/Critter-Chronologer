package com.udacity.jdnd.course3.critter.presentation.pet;

import com.udacity.jdnd.course3.critter.persistence.Pet;
import org.springframework.stereotype.Component;

@Component
public class PetConverter {

    public Pet toDomain(PetDTO petDTO) {
        Pet pet = new Pet();
        pet.setId(petDTO.getId());
        pet.setBirthDate(petDTO.getBirthDate());
        pet.setName(petDTO.getName());
        pet.setNotes(petDTO.getNotes());
        pet.setOwnerId(petDTO.getOwnerId());
        pet.setType(petDTO.getType());
        return pet;
    }

    public PetDTO fromDomain(Pet pet) {
        PetDTO petDTO = new PetDTO();
        petDTO.setId(pet.getId());
        petDTO.setBirthDate(pet.getBirthDate());
        petDTO.setName(pet.getName());
        petDTO.setNotes(pet.getNotes());
        petDTO.setOwnerId(pet.getOwnerId());
        petDTO.setType(pet.getType());
        return petDTO;
    }
}
