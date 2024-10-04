package com.todolist.todolist.repositories.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserClass {
    private Integer id;
    private String name;
    private String lastname;
    private String email;
}
