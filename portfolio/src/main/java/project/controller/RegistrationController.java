package project.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.model.binding.UserRegisterBindingModel;
import project.model.service.UserServiceModel;
import project.service.UserService;
import org.modelmapper.ModelMapper;


@RestController
@RequestMapping("/")  // Adjust the URL as needed
public class RegistrationController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public RegistrationController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserRegisterBindingModel userRegisterBindingModel,
                                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Handle validation errors, return bad request
            return ResponseEntity.badRequest().body("Invalid registration data");
        }

        // Map UserRegisterBindingModel to UserServiceModel using ModelMapper
        UserServiceModel userServiceModel = modelMapper.map(userRegisterBindingModel, UserServiceModel.class);

        // Save the user to the database using your UserService
        userService.registerUser(userServiceModel);

        return ResponseEntity.ok("Registration successful");
    }
}
