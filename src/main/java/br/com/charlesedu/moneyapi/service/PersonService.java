package br.com.charlesedu.moneyapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.charlesedu.moneyapi.model.Person;
import br.com.charlesedu.moneyapi.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person update(Long id, Person person) {
        Person personSaved = personRepository.findOne(id);

        if (personSaved == null) {
            throw new EmptyResultDataAccessException(1);
        }

        BeanUtils.copyProperties(person, personSaved, "id");

        personRepository.save(personSaved);

        return personSaved;
    }
}
