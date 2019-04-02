package com.billal.sprongframework.spring5weapp.bootstrap;

import com.billal.sprongframework.spring5weapp.model.Author;
import com.billal.sprongframework.spring5weapp.model.Book;
import com.billal.sprongframework.spring5weapp.model.Publisher;
import com.billal.sprongframework.spring5weapp.model.repositories.AuthorRepository;
import com.billal.sprongframework.spring5weapp.model.repositories.BookRepository;
import com.billal.sprongframework.spring5weapp.model.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();

    }

    private void  initData(){

        Publisher publisher1 = new Publisher();
        publisher1.setName("foo");
        publisher1.setAdress("Dir Hanna");

        Publisher publisher2 = new Publisher();
        publisher2.setName("fee");
        publisher2.setAdress("Arrabeh");

        publisherRepository.save(publisher1);
        publisherRepository.save(publisher2);

        Author billal = new Author("Billal" , "Taha");
        Book ddd = new Book("My new book" , "1234" , publisher1);
        billal.getBooks().add(ddd);
        ddd.getAuthor().add(billal);
        authorRepository.save(billal);
        bookRepository.save(ddd);

        Author rod = new Author("Rod" , "Evans");
        Book noEJB = new Book("JEE devlopment without EJB" , "22331" , publisher2);
        rod.getBooks().add(noEJB);
        noEJB.getAuthor().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
