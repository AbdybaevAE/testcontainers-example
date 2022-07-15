package kz.abdybayev.testcontainersexample.testcontainersdemo.controllers.dto;

import lombok.Data;
import javax.validation.constraints.NotEmpty;

@Data
public class AddTaskRequest {
    @NotEmpty
    private String taskTitle;
}
