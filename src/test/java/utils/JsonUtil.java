package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class JsonUtil {

    private static JsonNode root;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = JsonUtil.class
                    .getClassLoader()
                    .getResourceAsStream("testdata/loginData.json");
            root = mapper.readTree(is);
        } catch (Exception e) {
            throw new RuntimeException("Unable to load JSON");
        }
    }

    public static String get(String userType, String key) {
        return root.get(userType).get(key).asText();
    }

}
