package org.younes.data;

public interface Serializer {
    String serialize(Object data);
    Object deserialize(String serializedData, Class<?> type);
}


