import models.Task;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import services.ApiService;
import services.GeneratorService;

import static org.testng.Assert.*;

public class CreateNewTask {

    @Test
    void checkContent() {
        Task task = new Task()
                .withContent("content_" + GeneratorService.randomNumSequence(5));

        JSONObject response = ApiService.createNewTask(task);
        assertEquals(
                response.get("content"),
                task.getContent(),
                "Wrong content");
    }

    @Test
    void checkOrder() {
        Task task = new Task()
                .withContent("content_" + GeneratorService.randomNumSequence(5))
                .withOrder(13L);

        JSONObject response = ApiService.createNewTask(task);
        assertEquals(
                response.get("order"),
                task.getOrder(),
                "Wrong order");
    }

    @Test
    void checkPriority() {
        Task task = new Task()
                .withContent("content_" + GeneratorService.randomNumSequence(5))
                .withPriority(4L);

        JSONObject response = ApiService.createNewTask(task);
        assertEquals(
                response.get("priority"),
                task.getPriority(),
                "Wrong priority");
    }

}
