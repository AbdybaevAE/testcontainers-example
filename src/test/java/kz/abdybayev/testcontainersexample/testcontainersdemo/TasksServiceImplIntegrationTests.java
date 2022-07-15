package kz.abdybayev.testcontainersexample.testcontainersdemo;

import kz.abdybayev.testcontainersexample.testcontainersdemo.repositories.TasksRepository;
import kz.abdybayev.testcontainersexample.testcontainersdemo.services.TasksService;
import kz.abdybayev.testcontainersexample.testcontainersdemo.services.dto.AddTaskArguments;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(initializers = {TasksServiceImplIntegrationTests.Initializer.class})
@Testcontainers
public class TasksServiceImplIntegrationTests {
    @Autowired
    private TasksRepository tasksRepository;
    @Autowired
    private TasksService tasksService;
    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:11.1")
            .withDatabaseName("integration-tests-db")
            .withUsername("sa")
            .withPassword("sa");

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
                    "spring.datasource.username=" + postgreSQLContainer.getUsername(),
                    "spring.datasource.password=" + postgreSQLContainer.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }

    @Test
    public void tasksWereAddedAndReturned() {
        var TASK_NAME = "buy milk";
        // when, then
        assertTrue(tasksRepository.findAll().isEmpty());

        // when
        tasksService.addTask(new AddTaskArguments(TASK_NAME));

        //then
        var foundTasks = tasksService.getTasks();
        assertEquals(foundTasks.size(), 1);
        assertEquals(foundTasks.get(0).title(), TASK_NAME);
    }
}
