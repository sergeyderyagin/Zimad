package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Task;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Common api service
 */
public class ApiService extends BaseApiService {

    /**
     * Create new task
     * @param task Task -
     * @return
     */
    public static JSONObject createNewTask(Task task) {
        String url = "https://api.todoist.com/rest/v1/tasks";
        System.out.println("URL: " + url);

        JSONObject json = new JSONObject();

        // Add fields value of Task object to request body if they not equals null or zero or empty string
        Class<?> clazz = task.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAccessible()){
                field.setAccessible(true);
            }
            try {
                Object value = field.get(task);
                if ((value != null) && (!value.toString().equals("0") && (value != ""))) {
                    json.put(field.getName(), value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        String body = null;
        try {
            body = new ObjectMapper().writeValueAsString(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println("BODY: " + body);

        try {
            JSONObject response = BaseApiService.post(url, body);
            System.out.println("RESPONSE: " + response);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JSONObject();
    }
}
