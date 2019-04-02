package com.billal.sprongframework.spring5weapp.model.repositories;

import com.billal.sprongframework.spring5weapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book , Long> {
}
