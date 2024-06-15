package br.com.projetoa3.exception;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Classe responsável por serializar um objeto LocalDateTime em uma string JSON.
 */
public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    /** Formato padrão de data e hora utilizado para serialização. */
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Método responsável por serializar um objeto LocalDateTime em uma string JSON.
     * @param value O objeto LocalDateTime a ser serializado.
     * @param gen O gerador JSON.
     * @param serializers O provedor de serializadores.
     * @throws IOException Se ocorrer um erro de entrada/saída durante a serialização.
     */
    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers)
            throws IOException {
        String formattedDateTime = value.format(FORMATTER);
        gen.writeString(formattedDateTime);
    }
}