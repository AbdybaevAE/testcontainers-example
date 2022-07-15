package kz.abdybayev.testcontainersexample.testcontainersdemo.repositories;

import kz.abdybayev.testcontainersexample.testcontainersdemo.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends JpaRepository<TaskEntity, Long> {
}
