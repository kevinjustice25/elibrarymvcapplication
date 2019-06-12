package edu.mum.cs425.lab8.elibrary_mvc.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "Books")
public class Book {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private int bookid;


    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "fee", nullable = false, precision = 2)
    private float fee;

    @Column(name = "date_published", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datepublished;

    public Book() {
    }

    public Book(String title, float fee, LocalDate datepublished) {
        this.title = title;
        this.fee = fee;
        this.datepublished = datepublished;
    }


    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public LocalDate getDatepublished() {
        return datepublished;
    }

    public void setDatepublished(LocalDate datepublished) {
        this.datepublished = datepublished;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", title='" + title + '\'' +
                ", fee=" + fee +
                ", datepublished=" + datepublished +
                '}';
    }
}

