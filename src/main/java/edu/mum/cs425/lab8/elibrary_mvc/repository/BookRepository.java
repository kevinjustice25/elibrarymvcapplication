package edu.mum.cs425.lab8.elibrary_mvc.repository;

import edu.mum.cs425.lab8.elibrary_mvc.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}
