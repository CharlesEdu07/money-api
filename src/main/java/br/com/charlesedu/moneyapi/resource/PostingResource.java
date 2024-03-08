package br.com.charlesedu.moneyapi.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.charlesedu.moneyapi.event.ResourceCreatedEvent;
import br.com.charlesedu.moneyapi.model.Posting;
import br.com.charlesedu.moneyapi.repository.filter.PostingFilter;
import br.com.charlesedu.moneyapi.service.PostingService;

@RestController
@RequestMapping("/postings")
public class PostingResource {

    @Autowired
    private PostingService postingService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping
    public ResponseEntity<Posting> save(@Valid @RequestBody Posting posting, HttpServletResponse response) {
        Posting postingSaved = postingService.save(posting);

        publisher.publishEvent(new ResourceCreatedEvent(this, response, postingSaved.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(postingSaved);
    }

    @GetMapping
    public Page<Posting> find(PostingFilter postingFilter, Pageable pageable) {
        Page<Posting> postings = postingService.find(postingFilter, pageable);

        return postings;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Posting posting = postingService.findById(id);

        return ResponseEntity.ok(posting);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        postingService.delete(id);
    }
}
