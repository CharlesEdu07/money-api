package br.com.charlesedu.moneyapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.charlesedu.moneyapi.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Page<Person> findByPersonNameContainingOrderByIdAsc(String personName, Pageable pageable);
}
