package services;

import okhttp3.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class BaseApiService {
    private static String TOKEN = "94da94b535f6279a29aa8ea1a3bb2c42dac4de3f";
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private static OkHttpClient client = new OkHttpClient();

    public static JSONObject post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .header("Authorization", "Bearer " + TOKEN)
                .url(url)
                .post(body)
                .build();

        Response response = client.newCall(request).execute();

        JSONParser parser = new JSONParser();
        try {
            return  (JSONObject) parser.parse(response.body().string());
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            response.close();
        }

        return new JSONObject();
    }
}
