package se.ecutb.peter.thymeleaf_introduction.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {

    public List<String> contactList = new ArrayList<>();

    //Create a method named ”index” that will return a String
    @GetMapping("/index")
    public String index(Model model){
    return "index";
    }

    //Create a method named ”contact” that will return a String
    @GetMapping("/contact")
    public String contact(Model model){
        model.addAttribute("contacts", contactList);    //Lägg till listan här
        return "contact";
    }

    //Create a method named ”contact” that will take a String as input and return a String
    @PostMapping("/contact")
    public String contact(@RequestParam String myString){
        if(!myString.isEmpty()){
            contactList.add(myString);
        }
        return "redirect:/contact";
    }

    //Create a method named ”contactList” that will take a Model as input named model
    public void contactList(Model model,  List<String> contactList){
        model.addAttribute("contacts", contactList);
    }

    //Create a method named ”about” and a View for it
    @GetMapping("/about")
    public void about(Model model){
    }

}


    //ska vi göra 2 metoder i "Home" som BÅDA heter "contact"? en med @Post och en med @Get vi pratar om url



