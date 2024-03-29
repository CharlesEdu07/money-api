package br.com.charlesedu.moneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.charlesedu.moneyapi.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
