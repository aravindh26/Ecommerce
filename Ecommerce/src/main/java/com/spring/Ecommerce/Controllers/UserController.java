package com.spring.Ecommerce.Controllers;

import com.spring.Ecommerce.DTO.CreateUserDTO;
import com.spring.Ecommerce.DTO.getUserDTO;
import com.spring.Ecommerce.Model.User;
import com.spring.Ecommerce.Services.UserServices;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping
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


}
