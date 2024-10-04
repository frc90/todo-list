package com.todolist.todolist.repositories.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class TaskClass {
    private Integer id;
    private String name;
    private boolean state;
}
