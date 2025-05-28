package com.example.projetobd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT) // HTTP 409 Conflict
public class AvaliacaoJaExistenteException extends RuntimeException {
    public AvaliacaoJaExistenteException(String mensagem) {
        super(mensagem);
    }
}