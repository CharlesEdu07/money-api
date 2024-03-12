package br.com.charlesedu.moneyapi.repository.posting;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.charlesedu.moneyapi.model.Posting;
import br.com.charlesedu.moneyapi.repository.filter.PostingFilter;
import br.com.charlesedu.moneyapi.repository.projection.PostingProjection;

public interface PostingRepositoryQuery {
    public Page<Posting> filter(PostingFilter postingFilter, Pageable pageable);

    public Page<PostingProjection> projection(PostingFilter postingFilter, Pageable pageable);
}
