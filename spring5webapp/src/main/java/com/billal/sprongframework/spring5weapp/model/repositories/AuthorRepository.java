package com.billal.sprongframework.spring5weapp.model.repositories;

import com.billal.sprongframework.spring5weapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
