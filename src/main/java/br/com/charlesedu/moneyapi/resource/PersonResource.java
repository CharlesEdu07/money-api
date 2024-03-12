package br.com.charlesedu.moneyapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.charlesedu.moneyapi.event.ResourceCreatedEvent;
import br.com.charlesedu.moneyapi.model.Person;
import br.com.charlesedu.moneyapi.repository.PersonRepository;
import br.com.charlesedu.moneyapi.service.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonResource {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_REGISTER_PERSON') and #oauth2.hasScope('write')")
    public ResponseEntity<Person> save(@Valid @RequestBody Person person, HttpServletResponse response) {
        Person personSaved = personRepository.save(person);

        publisher.publishEvent(new ResourceCreatedEvent(this, response, personSaved.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(personSaved);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_VIEW_PERSON') and #oauth2.hasScope('read')")
    public ResponseEntity<?> findAll() {
        List<Person> persons = personRepository.findAll();

        return ResponseEntity.ok(persons);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_VIEW_PERSON') and #oauth2.hasScope('read')")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        Person person = personService.findById(id);

        return ResponseEntity.ok(person);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_UPDATE_PERSON') and #oauth2.hasScope('write')")
    public ResponseEntity<Person> update(@PathVariable Long id, @Valid @RequestBody Person person) {
        Person personSaved = personService.update(id, person);

        return ResponseEntity.ok(personSaved);
    }

    @PutMapping("/{id}/active")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('ROLE_UPDATE_PERSON') and #oauth2.hasScope('write')")
    public void updatePropertyActive(@PathVariable Long id, @RequestBody Boolean active) {
        personService.updatePropertyActive(id, active);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('ROLE_DELETE_PERSON') and #oauth2.hasScope('write')")
    public void delete(@PathVariable("id") Long id) {
        personRepository.delete(id);
    }
}
