package com.todolist.todolist.controllers;

import com.todolist.todolist.models.User;
import com.todolist.todolist.repositories.UserRepository;
import com.todolist.todolist.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository repository;

    @GetMapping
    @ResponseBody
    public List<User> createAllPersons(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getPerson(@PathVariable Integer id){
        return userService.findUserById(id);
    }

    @PostMapping
    @ResponseBody
    public User createPerson(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public String updatePerson(@PathVariable Integer id, @RequestBody User user){
        if (userService.updateUserById(user, id) != null) {
            return "User updated with exit";
        }
        return "Sorry was an error!";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable Integer id){
        userService.deleteUser(id);
        return "User delete with exit!";
    }

    @PostMapping("/login")
    public User login(@RequestBody User user){
        return userService.userLogin(user.getUser(), user.getPassword());
    }

    @GetMapping("/getUser")
    public User existUser(@RequestBody User user){
        return userService.existUser(user.getUser());
    }
}
