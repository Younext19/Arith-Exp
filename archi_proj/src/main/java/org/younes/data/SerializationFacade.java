package org.younes.data;

public class SerializationFacade {
    private final Serializer serializer;

    public SerializationFacade(Serializer serializer) {
        this.serializer = serializer;
    }

    public String serialize(Object data) {
        return serializer.serialize(data);
    }

    public Object deserialize(String serializedData, Class<?> type) {
        return serializer.deserialize(serializedData, type);
    }
}
