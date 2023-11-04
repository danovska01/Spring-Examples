package com.danovska01.controllers_demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    //return a String from a /test1 url
    @GetMapping("/test1")
    @ResponseBody
    public String printHello(){
        return "Hello World";
    }

    @GetMapping("/test2")
    public String showHelloPage(){
        return "HelloPage";
    }

    @GetMapping("/test3")
    public String showHelloPageThymeleaf(Model model){
        model.addAttribute("message", "This is the message from thr html");
        return "HelloPageThymeleaf";
    }

    @GetMapping("/test4")
    public String showHelloPageThymeleaf_2(Model model){
        model.addAttribute("message", "This is the message");
        model.addAttribute("report", 88);
        model.addAttribute("rating", "Rating AAA from html");

        return "HelloPageThymeleaf_2";
    }

    @GetMapping("/test5")
    public ModelAndView showHelloPageAgainThymeleaf_2(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Message from ModelAndView");
        mv.addObject("rating", 1000);
        mv.setViewName("HelloPageThymeleaf_2");

        return mv;
    }

    ///test6?message=
    ///test6?message= here you type your message
    @GetMapping("/test6")
    public String showHelloPageParameter(@RequestParam ("message") String message, Model model) {
       model.addAttribute("message", message);
       model.addAttribute("rating", 22222);
       model.addAttribute("report", "new Report");

       return "HelloPageThymeleaf_2";

    }


}
