package br.com.projetoa3.exception;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * Classe responsável por desserializar uma string JSON em um objeto LocalDateTime.
 */
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    /** Formato padrão de data e hora utilizado para desserialização. */
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Método responsável por desserializar uma string JSON em um objeto LocalDateTime.
     * @param p O analisador JSON.
     * @param ctxt O contexto de desserialização.
     * @return O objeto LocalDateTime desserializado.
     * @throws IOException Se ocorrer um erro de entrada/saída durante a desserialização.
     */
    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String dateString = p.getText();
        return LocalDateTime.parse(dateString, FORMATTER);
    }
}