package com.billal.sprongframework.spring5weapp.controllers;

/*
 * Created by Billal Taha
 * User: BILLALT
 * Date: 4/2/2019
 * Time: 4:32 PM
 */

import com.billal.sprongframework.spring5weapp.model.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthor(Model model){
        model.addAttribute("authors",authorRepository.findAll());
        return "authors";
    }
}
