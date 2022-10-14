package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
public class Person {

    @Id
    private long id;
    private String name;
    private String lastName;
    private int age;
}
