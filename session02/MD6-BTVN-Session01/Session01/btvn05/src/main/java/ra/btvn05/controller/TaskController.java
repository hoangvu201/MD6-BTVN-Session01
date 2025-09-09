package ra.btvn05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.btvn05.entity.Tasks;
import ra.btvn05.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Tasks>> getAllTasks() {
        return ResponseEntity.ok(taskService.getTasks());
    }

    @PostMapping
    public ResponseEntity<Tasks> insertTask(@RequestBody Tasks tasks) {
        return new ResponseEntity<>(taskService.insertTask(tasks), HttpStatus.CREATED);
    }
}
