package com.mikro.interview.phonebook.utils;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class PhoneNumberValidator implements Predicate<String> {

    @Override
    public boolean test(String phoneNumber) {

        if(phoneNumber.startsWith("+234") && phoneNumber.length() == 14){
            return  true;
        }
        return false;
    }
}
