package project.controller;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import project.model.binding.UserLoginBindingModel;
import project.model.binding.UserRegisterBindingModel;
import project.model.service.UserServiceModel;
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


    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserRegisterBindingModel user = new UserRegisterBindingModel();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserRegisterBindingModel userRegisterBindingModel,
                               BindingResult result,
                               Model model){



        if(result.hasErrors()){
            model.addAttribute("user", userRegisterBindingModel);
            return "/register";
        }

        userService.registerUser(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model){
        // create model object to store form data
        UserLoginBindingModel user = new UserLoginBindingModel();
        model.addAttribute("user", user);
        return "login";
    }



}
