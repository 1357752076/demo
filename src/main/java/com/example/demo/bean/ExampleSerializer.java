package com.example.demo.bean;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * Created byCaoJieBing on 2018/7/17.
 */
@JsonComponent
public class ExampleSerializer {

    public static class Serializer extends JsonSerializer<Customer2>{

        @Override
        public void serialize(Customer2 customer2, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        }
    }

}
