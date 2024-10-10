package org.example.pro1.api;

import org.example.pro1.dto.TaskDTO;
import org.example.pro1.facade.TasksFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@Controller
@RequestMapping(value = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
public class TasksAPI {
    @Autowired
    private TasksFacade tasksFacade;

    @PostMapping
    @ResponseBody
    public TaskDTO create(@RequestBody TaskDTO taskDTO) {
       return tasksFacade.createTask(taskDTO);
    }

    @PutMapping("/{taskId}")
    @ResponseBody
    public TaskDTO update(@PathVariable("taskId") String taskId,
                          @RequestBody TaskDTO taskDTO) {
        return tasksFacade.updateTask(taskDTO, Long.valueOf(taskId));
    }

    @GetMapping
    @ResponseBody
    public List<TaskDTO> getAll() {
        return tasksFacade.getAll();
    }

    @DeleteMapping("/{taskId}")
    @ResponseBody
    public String delete(@PathVariable("taskId") Long taskId) {
        return tasksFacade.delete(taskId);
    }
}
