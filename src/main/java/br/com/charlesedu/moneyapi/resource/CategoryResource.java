package br.com.charlesedu.moneyapi.resource;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.charlesedu.moneyapi.event.ResourceCreatedEvent;
import br.com.charlesedu.moneyapi.model.Category;
import br.com.charlesedu.moneyapi.repository.CategoryRepository;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_REGISTER_CATEGORY')")
    public ResponseEntity<Category> save(@Valid @RequestBody Category category, HttpServletResponse response) {
        Category categorySaved = categoryRepository.save(category);

        publisher.publishEvent(new ResourceCreatedEvent(this, response, categorySaved.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(categorySaved);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_VIEW_CATEGORY')")
    public ResponseEntity<?> findAll() {
        List<Category> categories = categoryRepository.findAll();

        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_VIEW_CATEGORY')")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        Category category = categoryRepository.findOne(id);

        if (category == null) {
            throw new EmptyResultDataAccessException(1);
        } else {
            return ResponseEntity.ok(category);
        }
    }
}
