package br.com.projetoa3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exceção lançada quando um recurso não é encontrado.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    /**
     * Construtor que recebe uma mensagem de erro.
     * @param message A mensagem de erro a ser associada à exceção.
     */
    public ResourceNotFoundException(String message){
        super(message);
    }
}