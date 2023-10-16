package org.younes.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;

public class XmlSerializer implements Serializer {
    private final ObjectMapper objectMapper;

    public XmlSerializer() {
        this.objectMapper = new XmlMapper();
    }

    @Override
    public String serialize(Object data) {
        try {
            return objectMapper.writeValueAsString(data);
        } catch (IOException e) {
            throw new RuntimeException("Error serializing object to XML", e);
        }
    }

    @Override
    public Object deserialize(String serializedData, Class<?> type) {
        try {
            return objectMapper.readValue(serializedData, type);
        } catch (IOException e) {
            throw new RuntimeException("Error deserializing object from XML", e);
        }
    }
}
