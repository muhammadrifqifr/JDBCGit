package com.example.demo.controllers;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.daos.RegionDAO;
import com.example.demo.models.Region;
import com.example.demo.tools.DBConnection;

@Controller
@RequestMapping("region")
public class RegionController {
    private RegionDAO regionDAO = new RegionDAO(DBConnection.getConnection());

    // GET ALL
    @GetMapping
    public String index(Model model){
        model.addAttribute("regions", regionDAO.getAll());
        return "region/index";
    }

    //CREATE
    //GET
    @GetMapping(value = {"form", "form/{id}"})
    public String getById(@PathVariable(required = false) Integer id, Model model){
        if (id != null){
            model.addAttribute("region", regionDAO.getById(id));
        } else {
            model.addAttribute("region", new Region());
        }
        return "region/form";
    }

    //POST
    @PostMapping("save")
    public String save(@Nullable Region region){
        Boolean result; 
        if(region.getId() != null){
            result = regionDAO.update(region);
        } else {
            result = regionDAO.insert(region);
        }
        if (result){
            return "redirect:/region";
        } else {
            return "region/form";
        }
    }

 //DELETE
    //POST
    @PostMapping(value = {"delete/{id}"})
    public String delete(@PathVariable(required = false) Integer id){
        regionDAO.delete(id);
        return "redirect:/region";
    }
        


    //UPDATE
        //GET
    // @GetMapping (value = {"form/{id}"})
    // public String update(@PathVariable(required = false) Integer id, Model model){
    //     // dummy tidak pake method get by id
    //     // Region region = new Region();
    //     // region.setId(1);
    //     // region.setName("DKI");
    //     // model.addAttribute("region", region);
    //     // return "region/form";
        
    //     // Used
    //      model.addAttribute("region", regionDAO.getById(id));
    //      return "region/formEdit";
    // }

         //POST
    // @PostMapping("edit")
    // public String edit(Region region){
    //     Boolean result = regionDAO.update(region);
    //     if (result){
    //         return "redirect:/region";
    //     } else {
    //         return "region/formEdit";
    //     }
    // }

   
}
