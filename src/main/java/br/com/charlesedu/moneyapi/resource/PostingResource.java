package br.com.charlesedu.moneyapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.charlesedu.moneyapi.model.Posting;
import br.com.charlesedu.moneyapi.service.PostingService;

@RestController
@RequestMapping("/postings")
public class PostingResource {

    @Autowired
    private PostingService postingService;

    @GetMapping
    public ResponseEntity<?> list() {
        List<Posting> postings = postingService.findAll();

        return ResponseEntity.ok(postings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Posting posting = postingService.findById(id);

        return ResponseEntity.ok(posting);
    }
}
