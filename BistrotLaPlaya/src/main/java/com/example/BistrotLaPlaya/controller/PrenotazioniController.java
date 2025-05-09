package com.example.BistrotLaPlaya.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.management.loading.ClassLoaderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.BistrotLaPlaya.model.Prenotazioni;
import com.example.BistrotLaPlaya.repository.PrenotazionRepository;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/prenotazioni")
public class PrenotazioniController {

    @Autowired PrenotazionRepository prenotazioniRepository;
    
    
    


    @GetMapping("/all")
    public String ListPrenotazioni(@RequestParam(name="sdate", required = false, defaultValue = "") String sdate, Model model) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String stringDate = LocalDateTime.now().minusDays(30).format(formatter);

        List<Map<String, Prenotazioni>> prenotazioni = prenotazioniRepository.findAllByGiorno(sdate.isEmpty() ? stringDate : sdate);
        model.addAttribute("prenotazioni", prenotazioni);
        model.addAttribute("sdate", sdate.isEmpty() ? stringDate : sdate);
        return "index";
    }

    @GetMapping("/html")
    @ResponseBody
    public String getHtmlResponse() {
        return "<html><body><h1>Response Body Example</h1></body></html>";
    }

    @PostMapping("/ins")
    public String save(@ModelAttribute("prenotazione") Prenotazioni prenotazione,RedirectAttributes redirectAttributes) {
        String msg = "INSERT OK";
        try {
            prenotazioniRepository.save(prenotazione);
            redirectAttributes.addFlashAttribute("msg", msg);
            redirectAttributes.addFlashAttribute("style", "alert alert-success");
        } catch (Exception e) {
            msg = "INSERT ERROR: " + e.getMessage();
        }
        //TODO: process POST request
        
        return "redirect:/prenotazioni/all";
    }
    
}

