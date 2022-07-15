package kz.abdybayev.testcontainersexample.testcontainersdemo.services;

import kz.abdybayev.testcontainersexample.testcontainersdemo.entities.TaskEntity;
import kz.abdybayev.testcontainersexample.testcontainersdemo.repositories.TasksRepository;
import kz.abdybayev.testcontainersexample.testcontainersdemo.services.dto.AddTaskArguments;
import kz.abdybayev.testcontainersexample.testcontainersdemo.services.dto.GetTaskItemResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TasksServiceImpl implements TasksService {
    private final TasksRepository tasksRepository;

    @Override
    public void addTask(AddTaskArguments payload) {
        var taskEntity = new TaskEntity();
        taskEntity.setTitle(payload.title());
        tasksRepository.saveAndFlush(taskEntity);
    }

    @Override
    public List<GetTaskItemResult> getTasks() {
        return tasksRepository.findAll()
                .stream()
                .map(taskEntity -> new GetTaskItemResult(taskEntity.getId(), taskEntity.getTitle()))
                .collect(Collectors.toList());
    }
}
