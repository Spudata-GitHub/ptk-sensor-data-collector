package com.spudata.ptk_sensor_data_collector.utils;

import java.lang.reflect.Type;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.google.common.base.Preconditions;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

// https://www.javatips.net/api/go-maven-poller-master/src/main/java/com/oneandone/go/plugin/maven/util/ZonedDateTimeConverter.java
/**
 * Json (GSON) serializer/deserializer for converting JAVA 8 time api {@link ZonedDateTime} objects.
 *
 * @see JsonDeserializer
 * @see JsonDeserializer
 */
public class ZonedDateTimeConverter implements JsonSerializer<ZonedDateTime>, JsonDeserializer<ZonedDateTime> {

    /** Format specifier. */
    private final DateTimeFormatter dateTimeFormatter;

    public ZonedDateTimeConverter(final DateTimeFormatter dateTimeFormatter) {
        Preconditions.checkArgument(dateTimeFormatter != null, "dateTimeFormatter is null");
        this.dateTimeFormatter = dateTimeFormatter;
    }

    public JsonElement serialize(ZonedDateTime zonedDateTime, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(zonedDateTime.format(dateTimeFormatter));
    }

    public ZonedDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement.getAsString() == null || jsonElement.getAsString().isEmpty()) {
            return null;
        }

        return ZonedDateTime.parse(jsonElement.getAsString(), dateTimeFormatter);
    }
}