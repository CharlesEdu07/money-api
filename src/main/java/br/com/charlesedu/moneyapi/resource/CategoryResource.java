package br.com.charlesedu.moneyapi.resource;

import java.net.URI;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

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

import br.com.charlesedu.moneyapi.model.Category;
import br.com.charlesedu.moneyapi.repository.CategoryRepository;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity<?> list() {
        List<Category> categories = categoryRepository.findAll();

        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category, HttpServletResponse response) {
        Category categorySaved = categoryRepository.save(category);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categorySaved.getId())
                .toUri();

        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(categorySaved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        Category category = categoryRepository.findOne(id);

        if (category == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found");
        } else {
            return ResponseEntity.ok(category);
        }
    }
}