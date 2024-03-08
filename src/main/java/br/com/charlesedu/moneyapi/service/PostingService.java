package br.com.charlesedu.moneyapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.charlesedu.moneyapi.model.Person;
import br.com.charlesedu.moneyapi.model.Posting;
import br.com.charlesedu.moneyapi.repository.PostingRepository;
import br.com.charlesedu.moneyapi.repository.filter.PostingFilter;
import br.com.charlesedu.moneyapi.service.exception.InactiveOrNonExistentPersonException;

@Service
public class PostingService {

    @Autowired
    private PostingRepository postingRepository;

    @Autowired
    private PersonService personService;

    public Posting save(Posting posting) {
        Person person = personService.findPersonPostingById(posting.getPerson().getId());

        if (person == null || person.isInactive()) {
            throw new InactiveOrNonExistentPersonException();
        }

        return postingRepository.save(posting);
    }

    public Page<Posting> find(PostingFilter postingFilter, Pageable pageable) {
        return postingRepository.filter(postingFilter, pageable);
    }

    public Posting findById(Long id) {
        Posting postingSaved = postingRepository.findOne(id);

        if (postingSaved == null) {
            throw new EmptyResultDataAccessException(1);
        }

        return postingSaved;
    }

    public void delete(Long id) {
        postingRepository.delete(id);
    }
}
