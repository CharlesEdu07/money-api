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

    public Person findById(Long id) {
        Person personSaved = personRepository.findOne(id);

        if (personSaved == null) {
            throw new EmptyResultDataAccessException(1);
        }

        return personSaved;
    }

    public Person findPersonPostingById(Long id) {
        Person personSaved = personRepository.findOne(id);

        return personSaved;
    }

    public Person update(Long id, Person person) {
        Person personSaved = findById(id);

        BeanUtils.copyProperties(person, personSaved, "id");

        personRepository.save(personSaved);

        return personSaved;
    }

    public void updatePropertyActive(Long id, Boolean active) {
        Person personSaved = findById(id);

        personSaved.setActive(active);

        personRepository.save(personSaved);
    }
}
