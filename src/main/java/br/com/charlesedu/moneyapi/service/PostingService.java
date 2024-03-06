package br.com.charlesedu.moneyapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.charlesedu.moneyapi.model.Posting;
import br.com.charlesedu.moneyapi.repository.PostingRepository;

@Service
public class PostingService {

    @Autowired
    private PostingRepository postingRepository;

    public List<Posting> findAll() {
        return postingRepository.findAll();
    }

    public Posting findById(Long id) {
        return postingRepository.findOne(id);
    }
}
