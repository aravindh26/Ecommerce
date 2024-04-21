package com.spring.Ecommerce.Services;

import com.spring.Ecommerce.DTO.CreateUserDTO;
import com.spring.Ecommerce.Model.Batch;
import com.spring.Ecommerce.Model.Instructor;
import com.spring.Ecommerce.Model.User;
import com.spring.Ecommerce.Repository.InstructorRepository;
import com.spring.Ecommerce.Repository.UserRepository;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Getter
@Setter
@Data
@RestController
public class UserServices {

    private final UserRepository userdetails;
    private final InstructorRepository InstructorDetails;
    public UserServices(UserRepository userdetails, InstructorRepository instructorDetails)
    {
        this.userdetails = userdetails;
        this.InstructorDetails = instructorDetails;
    }



    public CreateUserDTO CreateUser(String email , String name)
    {

        User user = new User();
        CreateUserDTO DIOUser = new CreateUserDTO();
        user.setEmail(email);
        user.setName(name);

        userdetails.save(user);

        DIOUser.setName(name);
        DIOUser.setEmail(email);
        DIOUser.setStatus("User Creation Successful");
        DIOUser.setId(String.valueOf(user.getId()));





        return DIOUser;


    }

    public Instructor CreateInstructor(String email, String name, String specialization, String Sal) {

        Instructor Instructor = new Instructor();
        Instructor.setEmail(email);
        Instructor.setName(name);
        Instructor.setSalary(Sal);
        Instructor.setSpecialization(specialization);


        InstructorDetails.save(Instructor);



        return Instructor;


    }

    public  List<User>  getUser(String email)
    {


        System.out.println("email:"+email);
       List<User> userlist = userdetails.findByEmail(email);

        for (User user : userlist) {
            System.out.println("User ID: " + user.getId());
            System.out.println("User Name: " + user.getName());
            System.out.println("User Email: " + user.getEmail());
            // Print other user details if needed
        }

        return userlist;




    }
}
