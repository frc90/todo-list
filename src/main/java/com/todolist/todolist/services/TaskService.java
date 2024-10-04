package com.todolist.todolist.services;

import com.todolist.todolist.models.Task;
import com.todolist.todolist.repositories.TaskRepository;
import com.todolist.todolist.repositories.dto.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<TaskDto> getAllTask(){
        return TaskDto.getAllTaskWithUser(taskRepository.findAll());
    }

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public Task getTaskById(Integer id){
        return taskRepository.findById(id).orElse(null);
    }

    public String deleteTask(Integer id){
        taskRepository.deleteById(id);
        return "Task was remove with exits";
    }

    public String updateTask(Task task, Integer id){
        Task t =  taskRepository.findById(id).orElse(null);
        if (t != null) {
            t.setName(task.getName());
            t.setState(task.isState());
            t.setUser(task.getUser());
            System.out.println("task: " + task.toString());
            System.out.println("updated task: " + t.toString());
            taskRepository.save(t);
            return "Task was updated with exits";
        }
        return "Sorry!!!";
    }

    public Task changeStateOfTaskById(Boolean state, Integer id){
        Task t =  taskRepository.findById(id).orElse(null);
        if (t != null) {
            t.setState(state);
            taskRepository.save(t);
            return t;
        }
        return t;
    }

    public List<Task> getAllByState(Boolean state){
        return taskRepository.findByState(state);
    }
}
