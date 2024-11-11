package com.literalura.catalogo_libros.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConversorJSON {
    public <T> T convertirDesdeJSON(String json, Class<T> clase){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
