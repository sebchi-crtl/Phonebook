package com.mikro.interview.phonebook.controller;

import com.mikro.interview.phonebook.entity.Phonebook;
import com.mikro.interview.phonebook.service.PhonebookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/phonebook-details")
@AllArgsConstructor
@CrossOrigin
public class PhonebookController {

    private final PhonebookService phonebookService;

    //getting all phone details
    @GetMapping
    public List<Phonebook> getAllPhonebookDetails(){
        List<Phonebook> phonebook = phonebookService.selectAllPhonebook();
        return phonebook;
    }

    //get all phone numbers from database
    @GetMapping("/phone_numbers")
    public List<Phonebook> getAllPhoneNumbers(){
        List<Phonebook> phonebook = phonebookService.selectAllPhoneNumbers();
        return phonebook;
    }

    //Getting all the phone details by id
    @GetMapping(path = "/{id}")
    public Optional<Phonebook> getPhonebookDetailById(
            @PathVariable("id") Long id) {
        return phonebookService.getPhoneDetails(id);
    }

    //Select a number
    @GetMapping(value = "/number/{phoneNumber}")
    public List<Phonebook> getPhoneNumberById(
            @PathVariable("phoneNumber") String phoneNumber) {

        return phonebookService.getPhoneNumber(phoneNumber);

    }

    @PostMapping
    public void registerNewCustomer(
            @RequestBody Phonebook request) {
        String message = "Customer Saved Successfully "+ request.getName();
        phonebookService.addNewPhonebook(request);
    }
}
