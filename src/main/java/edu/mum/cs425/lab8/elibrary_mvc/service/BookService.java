package edu.mum.cs425.lab8.elibrary_mvc.service;

import edu.mum.cs425.lab8.elibrary_mvc.model.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);
    List<Book> findAll();
    Book getOne(Integer bookid);
    void delete(Integer bookid);
    void saveEditedBook(Book book);
}
