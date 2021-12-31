package com.mikro.interview.phonebook.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_phonebook")
public class Phonebook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(unique = true, name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name="date_created")
    private LocalDate DateCreated;


    public Phonebook(String name, String email, String phoneNumber,  LocalDate DateCreated) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.DateCreated = DateCreated;
    }

}
