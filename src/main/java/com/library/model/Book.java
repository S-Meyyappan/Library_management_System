package com.library.model;

import com.library.enums.BookStatus;
import com.library.enums.Genre;
import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    private Author author;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Enumerated(EnumType.STRING)
    private BookStatus status;

    @ManyToOne
    private Member borrowedBy;

    private int publicationYear;
}
