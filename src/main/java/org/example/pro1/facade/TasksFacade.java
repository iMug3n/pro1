package org.example.pro1.facade;

import org.example.pro1.dto.TaskDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TasksFacade {
    private static final Map<Long, TaskDTO> tasks = new HashMap<>();

    public TaskDTO createTask(TaskDTO taskDTO) {
        Long nextId = tasks.keySet().size() +1L;
        taskDTO.setId(nextId);
        tasks.put(nextId, taskDTO);
        return taskDTO;
    }

    public TaskDTO updateTask(TaskDTO taskDTO , Long id) {
        tasks.put(id, taskDTO);
        return taskDTO;
    }
    public TaskDTO getById(Long id) {
        return tasks.get(id);
    }

    public List<TaskDTO> getAll() {
        return new ArrayList<>(tasks.values());
    }

    public String delete(Long id) {
        tasks.remove(id);
        return "Deleted task with id " + id;
    }
}
