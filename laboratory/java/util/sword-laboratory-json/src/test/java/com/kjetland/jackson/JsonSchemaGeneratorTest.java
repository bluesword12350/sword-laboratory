package com.kjetland.jackson;

import com.fasterxml.jackson.JacksonBeanDemo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kjetland.jackson.jsonSchema.JsonSchemaGenerator;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class JsonSchemaGeneratorTest {

    @Test
    void jsonProperty() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonSchemaGenerator jsonSchemaGenerator = new JsonSchemaGenerator(mapper);
        JsonNode jsonSchema = jsonSchemaGenerator.generateJsonSchema(JacksonBeanDemo.class);
        String jsonSchemaAsString = mapper.writeValueAsString(jsonSchema);
        System.out.println(jsonSchemaAsString);
    }

}
