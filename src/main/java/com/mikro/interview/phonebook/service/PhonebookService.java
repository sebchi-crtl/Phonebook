package com.mikro.interview.phonebook.service;

import com.mikro.interview.phonebook.entity.Phonebook;
import com.mikro.interview.phonebook.repository.PhonebookRepository;
import com.mikro.interview.phonebook.utils.PhoneNumberValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PhonebookService {

    private final PhonebookRepository phonebookRepository;
    private final PhoneNumberValidator phoneNumberValidator;

    public List<Phonebook> selectAllPhonebook(){
        return phonebookRepository.findAll();
    }

    public List<Phonebook> selectAllPhoneNumbers(){
        return phonebookRepository.findAllByPhoneNumber();
    }

    public Optional<Phonebook> getPhoneDetails(Long id) {

        if(!phonebookRepository.existsById(id)) {
            throw new IllegalStateException(
                    "Phonebook Details with id " + id + " does not exists");
        }
        return phonebookRepository.findById(id);
    }

    public List<Phonebook> getPhoneNumber(String phoneNumber) {

        return phonebookRepository.findByPhoneNumber(phoneNumber);
    }

    public void addNewPhonebook(Phonebook phonebook)
    {

        phonebookRepository.save(phonebook);
    }

    public void updateStudent(Long id, Phonebook  newPhoneBook)
    {
        phonebookRepository.save(newPhoneBook);
    }

    public void deleteStudent(Long id)
    {
        phonebookRepository.deleteById(id);
    }

}
