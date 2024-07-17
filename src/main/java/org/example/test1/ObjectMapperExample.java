package org.example.test1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperExample {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        Person person = new Person("park", "female");
        System.out.println("person : " + person);
        try {
            // 직렬화

            String jsonString = objectMapper.writeValueAsString(person);

            /*
            writeValueAsString : 메서드를 사용하는 이 과정을 직렬화(serialize)
            Object - > format(JSON, XML, ...)
             */

            System.out.println("Serialized JSON: " + jsonString);

            // 역직렬화
            Person deserializedPerson = objectMapper.readValue(
                    jsonString, Person.class);
            System.out.println("deserializedPerson : " + deserializedPerson);
            System.out.println("Deserialized Person : Name = "
                    + deserializedPerson.getName() + ", Gender = "
                    + deserializedPerson.getGender());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
