package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.daos.DivisionDAO;
import com.example.demo.models.Division;
import com.example.demo.tools.DBConnection;

@Controller
@RequestMapping("division")
public class DivisionController {
    private DivisionDAO divisionDAO = new DivisionDAO(DBConnection.getConnection());

    // GET ALL
    @GetMapping
    public String index(Model model){
        Division division = new Division();
        division.setId(3);
        division.setName("Sport");
        division.setRegion();
        model.addAttribute( "divisions", divisionDAO.getAll());
        return "division/index";
    }
}
    // GET 
    // @GetMapping (value = {"form/{id}"})
    // public String 

