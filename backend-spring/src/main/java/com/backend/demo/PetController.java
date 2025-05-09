package com.backend.demo;

import application.openapi.generated.api.PetApi;
import application.openapi.generated.classes.Category;
import application.openapi.generated.classes.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController implements PetApi {

    @Override
    public ResponseEntity<Pet> getPetById(Long petId) {
        return ResponseEntity.ok(Pet
                .builder()
                .id(petId)
                .name("medor")
                .category(Category.builder().name("Chien").build())
                .build());
    }
}
