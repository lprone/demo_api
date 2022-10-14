package com.example.demo.transformer;

import com.example.demo.domain.Person;
import com.example.demo.request.CreatePersonRequest;
import com.example.demo.request.UpdatePersonRequest;
import org.springframework.stereotype.Component;

@Component
public class PersonTransformer {

    public Person transform(CreatePersonRequest request) {
        return Person.builder()
                .id(request.getId())
                .name(request.getName())
                .lastName(request.getLastName())
                .age(request.getAge())
                .build();
    }

    public Person transform(Long id, UpdatePersonRequest request) {
        return Person.builder()
                .id(id)
                .name(request.getName())
                .lastName(request.getLastName())
                .age(request.getAge())
                .build();
    }

    public Person transform(Person p) {
        return Person.builder()
                .id(p.getId())
                .name(p.getName())
                .lastName(p.getLastName())
                .age(p.getAge() + 1)
                .build();
    }
}
