package com.todolist.todolist.repositories;

import com.todolist.todolist.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByUserAndPassword(String user, String password);
    public User findByUser(String user);
}
