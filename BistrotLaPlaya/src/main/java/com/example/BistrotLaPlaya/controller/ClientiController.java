package com.example.BistrotLaPlaya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.BistrotLaPlaya.model.Clienti;
import com.example.BistrotLaPlaya.repository.clientiRepositpory;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/clienti")
public class ClientiController {
    
    @GetMapping("/all")
    public String listClienti(@RequestParam Model model) {
        List<Clienti> clienti = clientiRepositpory.findAll();
        model.addAttribute("clienti", clienti);
        return new String();
    }

    @GetMapping("new")
    public String showNewClientiForm(Model model) {
        model.addAttribute("cliente", new Clienti());
        return "newCliente";
    }

    @PostMapping("/ins")
    public String saveCliente(@ModelAttribute Clienti cliente) {
        return null;
        //TODO: process POST request
        
        
    }
    
    
    


}
