package factory.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.kodilla.patterns.factory.tasks.Task;
import com.kodilla.patterns.factory.tasks.TaskFactory;


class TaskFactoryTestSuite {

    @Test
    void testFactoryShoppingTask() {
        // Given
        TaskFactory factory = new TaskFactory();

        // When
        Task shopping = factory.makeTask(TaskFactory.SHOPPING);
        shopping.executeTask();

        // Then
        assertEquals("Grocery shopping", shopping.getTaskName());
        assertTrue(shopping.isTaskExecuted());
    }

    @Test
    void testFactoryPaintingTask() {
        // Given
        TaskFactory factory = new TaskFactory();

        // When
        Task painting = factory.makeTask(TaskFactory.PAINTING);
        painting.executeTask();

        // Then
        assertEquals("Wall painting", painting.getTaskName());
        assertTrue(painting.isTaskExecuted());
    }

    @Test
    void testFactoryDrivingTask() {
        // Given
        TaskFactory factory = new TaskFactory();

        // When
        Task driving = factory.makeTask(TaskFactory.DRIVING);
        driving.executeTask();

        // Then
        assertEquals("Business trip", driving.getTaskName());
        assertTrue(driving.isTaskExecuted());
    }
}
