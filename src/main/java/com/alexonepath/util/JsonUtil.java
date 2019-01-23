package com.alexonepath.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtil {
    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper() {
            {
                configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            }
        };
        mapper.setVisibility(mapper.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE)
        );

        mapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
        mapper.enable(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS);
    }

    public static String generateClassToJson(Object obj) {
        if (obj == null) {
            return null;
        }
        String json = null;
        try {
            json = mapper.writeValueAsString(obj);
        } catch (IOException e) {
        }
        return json;
    }

    public static <T> T generateJsonToClass(String jsonData, Class<T> valueTypeRef) {
        if (jsonData == null) {
            return null;
        }
        T object = null;
        try {
            object = mapper.readValue(jsonData, valueTypeRef);
        } catch (IOException e) {
        }
        return object;
    }
}
