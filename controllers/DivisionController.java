package com.example.demo.controllers;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.daos.DivisionDAO;
import com.example.demo.daos.RegionDAO;
import com.example.demo.models.Division;
import com.example.demo.tools.DBConnection;

@Controller
@RequestMapping("division")
public class DivisionController {
    private DivisionDAO divisionDAO = new DivisionDAO(DBConnection.getConnection());
    private RegionDAO regionDAO = new RegionDAO(DBConnection.getConnection());

    // GET ALL
    @GetMapping
    public String index(Model model){
        model.addAttribute( "divisions", divisionDAO.getAll());
        return "division/index";
    }

    //CREATE
    //GET
    @GetMapping(value = {"form", "form/{id}"})
    public String getById(@PathVariable(required = false) Integer id, Model model){
        if (id != null){
            model.addAttribute("division", divisionDAO.getById(id));
            model.addAttribute("regions", regionDAO.getAll());
        } else {
            model.addAttribute("division", new Division());
            model.addAttribute("regions", regionDAO.getAll());
        }
        return "division/form";
    }

    //POST
    @PostMapping("save")
    public String save(@Nullable Division division){
        Boolean result; 
        if(division.getId() != null){
            result = divisionDAO.update(division);
        } else {
            result = divisionDAO.insert(division);
        }
        if (result){
            return "redirect:/division";
        } else {
            return "division/form";
        }
    }

    //DELETE
    //POST
    @PostMapping(value = {"delete/{id}"})
    public String delete(@PathVariable(required = false) Integer id){
        divisionDAO.delete(id);
        return "redirect:/division";
    }
}
    // GET 
    // @GetMapping (value = {"form/{id}"})
    // public String 

