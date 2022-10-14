package com.example.demo.resources;

import com.example.demo.domain.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.request.CreatePersonRequest;
import com.example.demo.request.UpdatePersonRequest;
import com.example.demo.transformer.PersonTransformer;
import com.example.demo.validator.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PersonResource {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private PersonTransformer transformer;

    @Autowired
    private PersonValidator personValidator;


    @GetMapping("/person/mock")
    public ResponseEntity<Person> getMock() {
        return ResponseEntity.ok(Person.builder()
                .id(1)
                .name("John")
                .lastName("Doe")
                .age(20)
                .build());
    }

    @GetMapping("/person")
    public ResponseEntity<List<Person>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/person")
    public ResponseEntity<Person> createPerson(@RequestBody CreatePersonRequest request) {
        personValidator.validate(request);
        return ResponseEntity.ok(repository.save(transformer.transform(request)));
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody UpdatePersonRequest request) {
        personValidator.validate(request);
        return ResponseEntity.ok(repository.save(transformer.transform(id, request)));
    }

    @PutMapping("/person/{id}/birthday")
    public ResponseEntity<Person> birthdayPerson(@PathVariable Long id) {
        Optional<Person> p = repository.findById(id);
        if (p.isPresent()) {
            return ResponseEntity.ok(repository.save(transformer.transform(p.get())));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity deletePerson(@PathVariable Long id) {
        Optional<Person> p = repository.findById(id);
        if (p.isPresent()) {
            repository.delete(p.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
