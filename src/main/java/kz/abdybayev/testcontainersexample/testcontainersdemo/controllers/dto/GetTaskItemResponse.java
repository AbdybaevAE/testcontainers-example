package kz.abdybayev.testcontainersexample.testcontainersdemo.controllers.dto;

import kz.abdybayev.testcontainersexample.testcontainersdemo.services.dto.GetTaskItemResult;
import lombok.Getter;

@Getter
public class GetTaskItemResponse {
    private Long taskId;
    private String taskTitle;

    public GetTaskItemResponse(GetTaskItemResult task) {
        this.taskId = task.id();
        this.taskTitle = task.title();
    }
}
