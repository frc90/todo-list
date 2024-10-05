package com.todolist.todolist.repositories.dto;

import com.todolist.todolist.models.Task;
import com.todolist.todolist.models.User;
import com.todolist.todolist.repositories.util.TaskClass;
import com.todolist.todolist.repositories.util.UserClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@AllArgsConstructor
public class TaskDto {
    private Integer id;
    private String name;
    private boolean state;
    private UserClass user;

    public TaskDto(Integer id, String name, Boolean state, String email, UserClass user) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.user = user;
    }

    public static List<TaskDto> getAllTaskWithUser(@NonNull List<Task> tasks){
        return tasks
                .stream()
                .map(tsk -> {
                    if (tsk.getUser() == null) {
                         throw new IllegalArgumentException("Task have not any user.");
                    }
                    return new TaskDto(tsk.getId(), tsk.getName(), tsk.isState(),
                            new UserClass(
                            tsk.getUser().getId(),
                            tsk.getUser().getName(),
                            tsk.getUser().getLastname(),
                            tsk.getUser().getEmail()
                    ));
                }).collect(Collectors.toList());
    }
}
