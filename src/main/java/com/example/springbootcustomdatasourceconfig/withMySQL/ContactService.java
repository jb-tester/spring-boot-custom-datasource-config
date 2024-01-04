package com.example.springbootcustomdatasourceconfig.withMySQL;

import com.example.springbootcustomdatasourceconfig.withH2.Team;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public void displayAllTeams(){
        System.out.println("+++++++++++++++ all contacts: +++++++++++++++");
        for (Contact contact : contactRepository.findAll()) {
            System.out.println(contact);
        }
    }
}
