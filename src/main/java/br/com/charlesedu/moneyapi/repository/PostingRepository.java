package br.com.charlesedu.moneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.charlesedu.moneyapi.model.Posting;
import br.com.charlesedu.moneyapi.repository.posting.PostingRepositoryQuery;

@Repository
public interface PostingRepository extends JpaRepository<Posting, Long>, PostingRepositoryQuery {
    
}
