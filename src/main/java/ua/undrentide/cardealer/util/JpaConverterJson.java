package ua.undrentide.cardealer.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@Converter(autoApply = true)
public class JpaConverterJson implements AttributeConverter<Map<String, Object>, String> {
    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<String, Object> engineInfo) {
        String engineInfoJson = null;
        try {
            engineInfoJson = objectMapper.writeValueAsString(engineInfo);
        } catch (final JsonProcessingException e) {
            log.error("JSON writing error", e);
        }
        return engineInfoJson;
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String engineInfoJSON) {
        Map<String, Object> engineInfo = null;
        try {
            engineInfo = objectMapper.readValue(engineInfoJSON,
                    new TypeReference<HashMap<String, Object>>() {
                    });
        } catch (final IOException e) {
            log.error("JSON reading error", e);
        }
        return engineInfo;
    }
}