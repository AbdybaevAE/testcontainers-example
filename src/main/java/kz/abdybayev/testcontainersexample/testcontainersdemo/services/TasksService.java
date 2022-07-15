package kz.abdybayev.testcontainersexample.testcontainersdemo.services;

import kz.abdybayev.testcontainersexample.testcontainersdemo.services.dto.AddTaskArguments;
import kz.abdybayev.testcontainersexample.testcontainersdemo.services.dto.GetTaskItemResult;

import java.util.List;

public interface TasksService {
    void addTask(AddTaskArguments payload);

    List<GetTaskItemResult> getTasks();
}
