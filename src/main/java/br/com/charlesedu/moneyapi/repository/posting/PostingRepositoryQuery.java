package br.com.charlesedu.moneyapi.repository.posting;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.charlesedu.moneyapi.model.Posting;
import br.com.charlesedu.moneyapi.repository.filter.PostingFilter;

public interface PostingRepositoryQuery {
    public Page<Posting> filter(PostingFilter postingFilter, Pageable pageable);
}
