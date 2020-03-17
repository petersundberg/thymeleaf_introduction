package se.ecutb.peter.thymeleaf_introduction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ListController {

    public List<String> nameList = new ArrayList<>();

    @GetMapping("/list")
    public String getList(Model model){
        model.addAttribute("names", nameList);
        return "listview";
    }

    @PostMapping("/list")
    public String addName(@RequestParam String name){
        if(!name.isEmpty()){
            nameList.add(name);
        }
        return "redirect:/list";
    }

}
