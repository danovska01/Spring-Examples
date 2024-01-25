package project.controller;

import project.service.UserService;
import project.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    private final CurrentUser currentUser;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public HomeController(CurrentUser currentUser, UserService userService, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/")
    public String index(Model model){
        if(currentUser.getId() == null){
            return "index";
        }


        // TODO

        return "home";
    }



}
