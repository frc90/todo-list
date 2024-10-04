package com.todolist.todolist.repositories.dto;


import com.todolist.todolist.models.User;
import com.todolist.todolist.repositories.util.TaskClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private Integer id;
    private String name;
    private String lastname;
    private String email;

    private List<TaskClass> tasks;
    
    public static List<UserDto> getUserWithTask(@NonNull List<User> users){
        return users
                .stream()
                .map(us -> {
                    if (us == null) {
                        throw new IllegalArgumentException("Task have not any user.");
                    }
                    return new UserDto(
                            us.getId(),
                            us.getName(),
                            us.getLastname(),
                            us.getEmail(),
                            us.getTasks().stream()
                                    .map(task -> new TaskClass(task.getId(), task.getName(), task.isState()))
                                    .collect(Collectors.toList())
                    );
                }).collect(Collectors.toList());
    }
}
