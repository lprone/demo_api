package com.example.demo.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreatePersonRequest {
    private long id;
    private String name;
    private String lastName;
    private int age;
}
