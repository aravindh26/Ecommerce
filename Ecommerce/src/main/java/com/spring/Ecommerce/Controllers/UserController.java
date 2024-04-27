package com.spring.Ecommerce.Controllers;

import com.spring.Ecommerce.DTO.*;
import com.spring.Ecommerce.Model.Batch;
import com.spring.Ecommerce.Model.Instructor;
import com.spring.Ecommerce.Model.User;
import com.spring.Ecommerce.Services.UserServices;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RestController
@RequestMapping("/User")
public class UserController {

    private final UserServices UserService;

    public UserController(UserServices userService) {
        this.UserService = userService;
    }


   @PostMapping("/createuser")
    public CreateUserDTO CreateUser(@RequestBody CreateUserDTO CreateUser) {
        //Create User only if user is not available//
        List<User> isuseravailable = UserService.getUser(CreateUser.getEmail());

        CreateUserDTO DTO = new CreateUserDTO();
        if (isuseravailable.size() > 0) {
            for (User user : isuseravailable) {
                if (!user.getId().toString().equalsIgnoreCase("")) {
                    DTO.setId(user.getId().toString());
                    DTO.setName(user.getName());
                    DTO.setEmail(user.getEmail());
                    DTO.setStatus("User Already Exists for the Given EmailID");
                    return DTO;


                }


            }
        } else {
            return UserService.CreateUser(CreateUser.getEmail(), CreateUser.getName());
        }

        return DTO;
    }

    @GetMapping("/getuserdetails")
    public List<User> getuser(@RequestBody getUserDTO getuser) {
        return UserService.getUser(getuser.getEmail());
    }

    @PostMapping(value = "/CreateInstructor", consumes = MediaType.APPLICATION_JSON_VALUE)
    public InstructorDTO CreateInstructor(@RequestBody CreateInstructorDTO input) {
        // Call the CreateInstructorWithBatch method from UserService
        InstructorDTO instructorDTO = UserService.CreateInstructorWithBatch(input);
        return instructorDTO;
    }




}
