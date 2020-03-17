package se.ecutb.peter.thymeleaf_introduction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //gör klassen till en Bean
public class DemoController {

    //Definiera String parameter i greeting()
    //Vill visa Hello + "parameter" när det parametern inte är null
    //Modifiera greeting.html med ett formulär

    @GetMapping("/hello")     //@GetMapping({"/hello", "/",""})
    public String greeting(@RequestParam(value = "name", required = false) String name, Model model) {
        String message;
        if (name != null) {
            if (name.isEmpty()) {
                message = "Hello Stranger!";
            } else {
                message = "Hello " + name;
            }
        } else {
            message = "Hello " + name;
        }
        //return "greeting";

        model.addAttribute("greeting", message);
        return "greeting";
    }
}

//String message = name == null ? "Hello World!" : "Hello " + name;  //ternary operator
        //Initiera vå controller
        //Definiera vår HTML
        //Skapa en controller metod
        //Skriva ut Hello World i en HTML-fil med thymeleaf

//    @GetMapping("/hello")
//    public String greeting(Model model){
//        String message = "Hello World!";
//        model.addAttribute("greeting", message);
//        return "greeting";
//    }



