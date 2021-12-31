package com.mikro.interview.phonebook.repository;

import com.mikro.interview.phonebook.entity.Phonebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PhonebookRepository extends JpaRepository<Phonebook, Long> {


    List<Phonebook> findAllByPhoneNumber();

    List<Phonebook> findByPhoneNumber(String phoneNumber);
}
