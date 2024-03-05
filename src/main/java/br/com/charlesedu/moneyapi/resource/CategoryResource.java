package br.com.charlesedu.moneyapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.charlesedu.moneyapi.model.Category;
import br.com.charlesedu.moneyapi.repository.CategoryRepository;

@RestController
@RequestMapping("/categories")
public class CategoryResource {
    
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/list")
    public List<Category> list() {
        return categoryRepository.findAll();
    }
}
