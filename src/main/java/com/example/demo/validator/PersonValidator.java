package com.example.demo.validator;

import com.example.demo.exception.InvalidPersonException;
import com.example.demo.request.CreatePersonRequest;
import com.example.demo.request.UpdatePersonRequest;
import org.springframework.stereotype.Component;

@Component
public class PersonValidator {
    public void validate(CreatePersonRequest request) {
        if (request.getName() == null || request.getLastName() == null || request.getAge() < 0) {
            throw new InvalidPersonException(request.toString());
        }
    }

    public void validate(UpdatePersonRequest request) {
        if (request.getName() == null || request.getLastName() == null || request.getAge() < 0) {
            throw new InvalidPersonException(request.toString());
        }
    }
}
