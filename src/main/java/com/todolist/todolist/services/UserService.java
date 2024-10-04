package com.todolist.todolist.services;

import com.todolist.todolist.models.User;
import com.todolist.todolist.repositories.UserRepository;
import com.todolist.todolist.repositories.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDto> getAllUsers(){
        return UserDto.getUserWithTask(userRepository.findAll());
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUserById(User user, Integer id) {
        User p = userRepository.findById(id).orElse(null);
        if (p != null) {
            p = user;
//            p.setName(person.getName());
//            p.setLastname(person.getLastname());
//            p.setEmail(person.getEmail());
            userRepository.save(p);
            return p;
        }
        return null;
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public User userLogin(String user, String password){
        return userRepository.findByUserAndPassword(user, password);
    }

    public User existUser(String user){
        return userRepository.findByUser(user);
    }

    public String getUserNameById(Integer id){
        return userRepository.getByIdUserName(id);
    }
}
