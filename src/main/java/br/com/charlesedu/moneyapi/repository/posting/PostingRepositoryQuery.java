package br.com.charlesedu.moneyapi.repository.posting;

import java.util.List;

import br.com.charlesedu.moneyapi.model.Posting;
import br.com.charlesedu.moneyapi.repository.filter.PostingFilter;

public interface PostingRepositoryQuery {
    public List<Posting> filter(PostingFilter postingFilter);
}
