package br.com.charlesedu.moneyapi.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.charlesedu.moneyapi.model.Person;
import br.com.charlesedu.moneyapi.repository.PersonRepository;

@RestController
@RequestMapping("/persons")
public class PersonResource {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public ResponseEntity<?> list() {
        List<Person> persons = personRepository.findAll();

        return ResponseEntity.ok(persons);
    }

    @PostMapping
    public ResponseEntity<Person> create(@Valid @RequestBody Person person, HttpServletResponse response) {
        Person personSaved = personRepository.save(person);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(personSaved.getId())
                .toUri();

        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(personSaved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        Person person = personRepository.findOne(id);

        if (person == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found");
        } else {
            return ResponseEntity.ok(person);
        }
    }
}
