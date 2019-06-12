package edu.mum.cs425.lab8.elibrary_mvc.controller;

import edu.mum.cs425.lab8.elibrary_mvc.model.Book;
import edu.mum.cs425.lab8.elibrary_mvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping(value = "/addbook")
    public String newBookForm(Model model){
        model.addAttribute("book", new Book());
        return "books/addbookform";
    }

    @PostMapping(value = "/addbook")
    public String addNewBook(@Valid @ModelAttribute("book") Book book,
                             BindingResult result, Model model)  {

        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "books/addbookform";
        }

        book = bookService.save(book);
        System.out.println(book.toString());
        return "redirect:/books";
    }
    @GetMapping(value = "/books")
    public ModelAndView viewBooksList(){
        List<Book> booksList = bookService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("books",booksList);
        modelAndView.setViewName("books/books");
        return modelAndView;
    }

    @GetMapping(value = "book/{bookid}")
    public ModelAndView editBook(@PathVariable Integer bookid, Model model){
        Book book = bookService.getOne(bookid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("book",book);
        modelAndView.setViewName("books/edit");
        return modelAndView;
    }
    @PostMapping(value = "/editbook")
    public String saveEditedBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "books/edit";
        }
        bookService.saveEditedBook(book);
        System.out.println(book.toString());
        return "redirect:/books";
    }
    @GetMapping(value = "book/delete/{bookid}")
    public String deleteBook(@PathVariable Integer bookid){
        bookService.delete(bookid);
        return "redirect:/books";
    }

}
