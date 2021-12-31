package com.mikro.interview.phonebook.config;
import com.mikro.interview.phonebook.entity.Phonebook;
import com.mikro.interview.phonebook.repository.PhonebookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PhonebookConfig {
    @Bean
    CommandLineRunner commandLineRunner(PhonebookRepository repository){
        return args -> {
            Phonebook mariam = new Phonebook(
                    "Mariam",
                    "Mariam@mail.com",
                    "+2347034707850",
                    LocalDate.of(2000, Month.MAY, 20)
            );
            Phonebook alex = new Phonebook(
                    "Alex",
                    "Alex@gmail.com",
                    "+2349159402397",
                    LocalDate.of(1997, Month.SEPTEMBER, 2)
            );

            repository.saveAll(
                    List.of(mariam, alex)
            );
        };
    }

}
