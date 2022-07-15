package kz.abdybayev.testcontainersexample.testcontainersdemo.controllers;

import kz.abdybayev.testcontainersexample.testcontainersdemo.controllers.dto.AddTaskRequest;
import kz.abdybayev.testcontainersexample.testcontainersdemo.controllers.dto.GetTaskItemResponse;
import kz.abdybayev.testcontainersexample.testcontainersdemo.services.TasksService;
import kz.abdybayev.testcontainersexample.testcontainersdemo.services.dto.AddTaskArguments;
import kz.abdybayev.testcontainersexample.testcontainersdemo.utils.DataResponse;
import kz.abdybayev.testcontainersexample.testcontainersdemo.utils.ResponseStatus;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("tasks")
@AllArgsConstructor
public class TasksController {
    private final TasksService tasksService;

    @GetMapping
    public DataResponse getTasks() {
        return DataResponse.ok(
                tasksService.getTasks()
                        .stream()
                        .map(GetTaskItemResponse::new)
                        .collect(Collectors.toList())
        );
    }

    @PostMapping
    public ResponseStatus addTask(@RequestBody @Valid AddTaskRequest request) {
        var args = new AddTaskArguments(request.getTaskTitle());
        tasksService.addTask(args);
        return ResponseStatus.ok();
    }
}
