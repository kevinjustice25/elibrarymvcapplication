package edu.mum.cs425.lab8.elibrary_mvc.service.Impl;

import edu.mum.cs425.lab8.elibrary_mvc.model.Book;

import edu.mum.cs425.lab8.elibrary_mvc.repository.BookRepository;
import edu.mum.cs425.lab8.elibrary_mvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book save(Book book){
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = bookRepository.findAll();
        return books;
    }

    public Book getOne(Integer bookid){
        Book book = bookRepository.getOne(bookid);
        return book;
    }

    @Override
    public void delete(Integer bookid) {
        bookRepository.deleteById(bookid);
    }
    @Override
    public void saveEditedBook(Book book){
        if(bookRepository.existsById(book.getBookid())){
            System.out.println(book.getBookid() + "  book exists");
            bookRepository.deleteById(book.getBookid());
            bookRepository.save(book);
        }
    }
}
