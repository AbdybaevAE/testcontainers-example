package kz.abdybayev.testcontainersexample.testcontainersdemo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TASKS")
@Getter
@Setter
public class TaskEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TASK_ID")
    private Long id;

    @Column(name = "TASK_TITLE", nullable = false)
    private String title;

}
