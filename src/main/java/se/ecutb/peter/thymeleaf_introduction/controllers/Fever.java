package se.ecutb.peter.thymeleaf_introduction.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Fever {

    private double temperature = 0;

    @GetMapping("/temperature")
       public String temperature(@RequestParam(name = "temperature", required = false) Double temperature, Model model) {
        String resultMessage = "You haven't entered your temperature yet ...";
        if(temperature != null){
            if(temperature >= 0.0 && temperature <= 25.0){
                resultMessage = "Your temp is " + temperature + " (really?): " + "You are probably dead, from freezing! There is nothing you can do, literally!";
            }else if(temperature >= 25.1 && temperature <= 36.5){
                resultMessage = "Your temp is " + temperature + ": " + "You got hyperthermia! Go to hospital for help!";
            }else if(temperature > 36.5 && temperature <= 38.0){
                resultMessage = "Your temp is " + temperature + ": " + "Believe it or not, you are very much alive and doing well!";
            }else if(temperature >= 38.1 && temperature <= 42.5){
                resultMessage = "Your temp is " + temperature + ": " + "You got fever. See a doctor for help!";
            }
            else{
                resultMessage = "Your temp is " + temperature + " (really?): " + "You are probably dead, from overheating! There is nothing you can do, literally!";
            }
        }
        model.addAttribute("temperature", resultMessage);
        return "temperature";
    }

    @PostMapping("/temperature/process")
    public String process(@RequestParam("temperature") Double temperature){
        this.temperature = temperature;
        return "redirect:/temperature";
    }


}





